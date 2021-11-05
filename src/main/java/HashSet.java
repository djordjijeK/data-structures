import java.util.Iterator;

public class HashSet<T> implements Iterable<T>
{
    private HashTable<T, Object> map;
    private static final Object DUMMY = new Object();

    /**
     * HashSet constructor.
     */
    public HashSet()
    {
        this.map = new HashTable<>();
    }

    /**
     * HashSet constructor.
     * 
     * @param capacity - hash set capacity.
     */
    public HashSet(int capacity)
    {
        this.map = new HashTable<>(capacity);
    }

    /**
     * Adds a new element to the set.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param element  - an element to be added to the hash set. 
     * @return boolean - true if the element is added, false if the element already exists.
     */
    public boolean add(T element) 
    {
        return this.map.insert(element, HashSet.DUMMY) != HashSet.DUMMY;
    }
    
    /**
     * Removes an element from the hash set.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param key - an element to be removed.
     * @return V  - deleted value if exists, null otherwise.
     */
    public boolean remove(T element) 
    {
        return this.map.remove(element) == HashSet.DUMMY;
    }
    
    /**
     * Checks if an element exists in the hash set.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param element  - an element to check.
     * @return boolean - true if the element exists, false otherwise.
     */
    public boolean contains(T element) 
    {
        return this.map.containsKey(element);
    }

    /**
     * Returns set size.
     */
    public int size()
    {
        return this.map.size();
    }

    /**
     * Clears the set.
     */
    public void clear()
    {
        this.map.clear();
    }

    /**
     * Checks if the set is empty.
     */
    public boolean isEmpty()
    {
        return this.map.isEmpty();
    }

    @Override
    public Iterator<T> iterator() 
    {
        return this.map.iterator();    
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (T key : this.map) 
            sb.append(key + ", ");

        sb.append("]");
        return sb.toString(); 
    }
}
