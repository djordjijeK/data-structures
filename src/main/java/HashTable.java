@SuppressWarnings("unchecked")
public class HashTable<K, V>
{
    // hash table load factor
    private double loadFactor;

    // the total number of unique keys currently inside the hash table.
    private int keyCount;

    // the total number of used buckets inside the hash table (includes cells marked as deleted).
    private int usedBuckets;

    // hash table capacity, threshold for resizing.
    private int capacity;
    private int threshold;

    // arrays that store the key-value pairs.
    private K[] keys;
    private V[] values;

    // special marker token used to indicate the deletion of a key-value pair
    private final K TOMBSTONE = (K) (new Object());

    // hash table constants
    private static final int    DEFAULT_CAPACITY    = 25;
    private static final double DEFAULT_LOAD_FACTOR = 0.7;
    private static final int    LINEAR_CONSTANT     = 17; 
    
    /**
     * HashTable constructor.
     */
    public HashTable()
    {
        this(HashTable.DEFAULT_CAPACITY, HashTable.DEFAULT_LOAD_FACTOR);
    }

    /**
     * HashTable constructor.
     * 
     * @param capacity - hash table capacity.
     */
    public HashTable(int capacity)
    {
        this(capacity, HashTable.DEFAULT_LOAD_FACTOR);
    }

    /**
     * HashTable constructor.
     * 
     * @param capacity   - hash table capacity.
     * @param loadFactor - hash table load factor (used to determine when we need to resize).
     */
    public HashTable(int capacity, double loadFactor)
    {
        if (capacity <= 0)
            throw new IllegalArgumentException("Illegal capacity: " + capacity);

        if (loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

        this.capacity   = capacity;
        this.loadFactor = Math.max(HashTable.DEFAULT_CAPACITY, loadFactor);
        this.threshold  = (int) (this.loadFactor * this.capacity);

        // if needed, we need to adjust capacity to avoid probing cycles.
        this.adjustCapacity();
        
        this.keys   = (K[]) new Object[this.capacity];
        this.values = (V[]) new Object[this.capacity];
    }

    /**
     * Puts a new "key -> value" pair in hash table.
     * If the value already exists inside the hash table, the value is updated.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param key   - a key.
     * @param value - a value.
     * @return V    - previously assigned value for the given key.
     */
    public V put(K key, V value)
    {
        return insert(key, value);
    }

    /**
     * Adds a new "key -> value" pair in hash table.
     * If the value already exists inside the hash table, the value is updated.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param key   - a key.
     * @param value - a value.
     * @return V    - previously assigned value for the given key.
     */
    public V add(K key, V value)
    {
        return insert(key, value);
    }

    /**
     * Inserts a "new key" -> value pair in hash table.
     * If the value already exists inside the hash table, the value is updated.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param key   - a key.
     * @param value - a value.
     * @return V    - previously assigned value for the given key.
     */
    public V insert(K key, V value)
    {
        if (key == null)
            throw new IllegalArgumentException("Null key");

        if (this.usedBuckets >= this.threshold)
            this.resizeHashTable();

        final int offset = this.normalizeIndex(key.hashCode());

        for (int i = offset, j = -1, x = 1; ; i = normalizeIndex(offset + this.probe(x++))) 
        {
            // 1. the current slot was previously deleted
            if (this.keys[i] == this.TOMBSTONE)
            {
                if (j == -1) j = i;
            }
            // 2. the current cell already contains a key
            else if (this.keys[i] != null)
            {
                // the key we're trying to insert already exists in the hash-table,
                // so update its value with the most recent value
                if(this.keys[i].equals(key))
                {
                    V oldValue = this.values[i];

                    if (j == -1)
                    {
                        this.values[i] = value;
                    }
                    else
                    {
                        this.keys[i]   = this.TOMBSTONE;
                        this.values[i] = null;

                        this.keys[j]   = key;
                        this.values[j] = value; 
                    }

                    return oldValue;
                }

            }
            // 3. the current cell is null so an insertion/update can occur
            else
            {
                // no previously encountered deleted buckets
                if (j == -1)
                {
                    this.usedBuckets++;
                    this.keyCount++;

                    this.keys[i]   = key;
                    this.values[i] = value;
                }
                // previously seen deleted bucket. Instead of inserting
                // the new element at i where the null element is 
                // insert it where the deleted token was found.
                else
                {
                    this.keyCount++;

                    this.keys[j]   = key;
                    this.values[j] = value;
                }

                return null;
            }
        }
    }

    /**
     * Gets a value associated with the key.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key - a key.
     * @return V  - a value associated with the given key if the key exists, null otherwise.
     */
    public V get(K key)
    {
        if (key == null)
            throw new IllegalArgumentException("Null key");

        final int offset = this.normalizeIndex(key.hashCode());

        // start at the original hash value and probe until we find a spot where our key
        // is or we hit a null element in which case our element does not exist.
        for(int i = offset, j = -1, x = 1; ; i = this.normalizeIndex(offset + this.probe(x++)))
        {
            // 1. ignore deleted cells, but record where the first index 
            // of a deleted cell is found to perform lazy relocation later.
            if (this.keys[i] == this.TOMBSTONE)
            {
                if (j == -1) 
                    j = i;
            }
            // 2. we hit a non-null key, perhaps it's the one we're looking for.
            else if (this.keys[i] != null)
            {
                // if j != -1 this means we previously encountered a deleted cell.
                // We can perform an optimization by swapping the entries in cells
                // i and j so that the next time we search for this key it will be
                // found faster. This is called lazy deletion/relocation.
                if (this.keys[i].equals(key))
                {
                    if (j != -1)
                    {
                        this.keys[j]   = this.keys[i];
                        this.values[j] = this.values[i];
                        
                        this.keys[i]   = this.TOMBSTONE;
                        this.values[i] = null;

                        return this.values[j];
                    }
                    else
                    {
                        return this.values[i];
                    }
                }
            }
            // 3. the element was not found in the hash table.
            else
            {
                return null;
            }
        }
    }

    /**
     * Removes a "key -> value" pair from a hash table.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key - a key.
     * @return V  - deleted value if exists, null otherwise.
     */
    public V remove(K key)
    {
        if (key == null)
            throw new IllegalArgumentException("Null key");

        final int offset = this.normalizeIndex(key.hashCode());

        // starting at the original hash probe until we find a spot where our key is
        // or we hit a null element in which case our element does not exist.
        for(int i = offset, j = -1, x = 1; ; i = this.normalizeIndex(offset + this.probe(x++)))
        {
            if (this.keys[i] == this.TOMBSTONE)
                continue;
            else if (this.keys[i] == null) 
                return null;
            else 
            {
                this.keyCount--;

                V oldValue = this.values[i];

                this.keys[i]   = this.TOMBSTONE;
                this.values[i] = null;

                return oldValue;
            }
        }
    }

    /**
     * Deletes a "key -> value" pair from a hash table.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key - a key.
     * @return V  -
     */
    public V delete(K key)
    {
        return this.remove(key);
    }

    /**
     * Checks if the key exists in the hash table.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key      - a key.
     * @return boolean - true if the key exists, false otherwise.
     */
    public boolean hasKey(K key)
    {
        if (key == null)
            throw new IllegalArgumentException("Null key");

        final int offset = this.normalizeIndex(key.hashCode());

        // start at the original hash value and probe until we find a spot where our key
        // is or we hit a null element in which case our element does not exist.
        for(int i = offset, j = -1, x = 1; ; i = this.normalizeIndex(offset + this.probe(x++)))
        {
            // 1. ignore deleted cells, but record where the first index 
            // of a deleted cell is found to perform lazy relocation later.
            if (this.keys[i] == this.TOMBSTONE)
            {
                if (j == -1) 
                    j = i;
            }
            // 2. we hit a non-null key, perhaps it's the one we're looking for.
            else if (this.keys[i] != null)
            {
                // if j != -1 this means we previously encountered a deleted cell.
                // We can perform an optimization by swapping the entries in cells
                // i and j so that the next time we search for this key it will be
                // found faster. This is called lazy deletion/relocation.
                if (this.keys[i].equals(key))
                {
                    if (j != -1)
                    {
                        this.keys[j]   = this.keys[i];
                        this.values[j] = this.values[i];
                        
                        this.keys[i]   = this.TOMBSTONE;
                        this.values[i] = null;
                    }

                    return true;
                }
            }
            // 3. the element was not found in the hash table.
            else
            {
                return false;
            }
        }
    }

    /**
     * Checks if the key exists in the hash table.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key      - a key.
     * @return boolean - true if the key exists, false otherwise.
     */
    public boolean containsKey(K key)
    {
        return this.hasKey(key);
    }

    /**
     * Clears the hash table.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void clear()
    {
        for(int i = 0; i < this.capacity; i++)
        {
            this.keys[i] = null;
            this.values[i] = null;
        }

        this.keyCount = this.usedBuckets = 0;
    }

    /**
     * Returns size of the hash table (total active keys).
     */
    public int size()
    {
        return this.keyCount;
    }

    /**
     * Checks if hash table is empty.
     */
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    /**
     * Probing function.
     */
    private int probe(int x)
    {
        return HashTable.LINEAR_CONSTANT * x;
    }

    /**
     * Resizes the hash table. 
     * It doubles the size of the table and re-hashes the keys.
     * Time  Complexity: O(n)
     * Space Complexity: O(n)
     */
    private void resizeHashTable()
    {
        this.increaseCapacity();
        this.adjustCapacity();

        this.threshold = (int) (this.loadFactor * this.capacity);   // recalculate the new threshold

        K[] oldKeyTable   = this.keys;
        V[] oldValueTable = this.values;

        this.keys   = (K[]) new Object[this.capacity];
        this.values = (V[]) new Object[this.capacity];
        
        this.keyCount = this.usedBuckets = 0;   // reset performance indicators

        for(int i = 0; i < oldKeyTable.length; i++)
        {
            if (oldKeyTable[i] != null && oldKeyTable[i] != this.TOMBSTONE)
                this.insert(oldKeyTable[i], oldValueTable[i]);

            oldKeyTable[i]   = null;
            oldValueTable[i] = null;
        }
    }

    /**
     * Converts a hash value to an index. 
     * Essentially, this strips the negative sign and 
     * places the hash value in the domain [0, capacity)
     */
    private int normalizeIndex(int hashedKey)
    {
        return (hashedKey & 0x7FFFFFFF) % this.capacity;
    }

    /**
     * Increases hash table capacity.
     */
    private void increaseCapacity()
    {
        this.capacity = (2 * this.capacity) + 1;
    }

    /**
     * Adjusts capacity to avoid probing cycles. 
     */
    private void adjustCapacity()
    {
        while(HashTable.gcd(HashTable.LINEAR_CONSTANT, this.capacity) != 1)
            this.capacity = this.capacity + 1;
    }

    /**
     * Finds the greatest common denominator of x and y.
     * 
     * @param x    - a number.
     * @param y    - a number.
     * @return int - gcd between x and y. 
     */
    private static final int gcd(int a, int b) 
    {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
