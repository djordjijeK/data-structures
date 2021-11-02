@SuppressWarnings("unchecked")
public class HashTable<K, V>
{
    // hash table load factor
    private double loadFactor;

    // the total number of unique keys currently inside the hash table.
    private int keyCount;

    // the total number of used buckets inside the hash table (includes cells marked as deleted).
    private int usedBuckets;

    // hash table capacity, threshold for resizing, count of modifications.
    private int capacity;
    private int threshold;
    private int modificationCount;

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

                    this.modificationCount++;
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

                this.modificationCount++;
                return null;
            }

        }
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
