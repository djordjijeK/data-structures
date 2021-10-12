/**
 * Implementation of generic dynamic array data structure
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T>
{
    private T[] array;          // container
    private int length   = 0;   // current array length
    private int capacity = 0;   // array capcity

    /**
     * DynamicArray Constructor.
     */
    public DynamicArray()
    {
        this(16);
    }

    /**
     * DynamicArray Constructor.
     * 
     * @param capacity - array capacity.
     */
    public DynamicArray(int capacity)
    {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        this.array    = (T[]) new Object[this.capacity];
    }

    /**
     * Appends a new item at the end of an array.
     * Time:  worst-case = O(n), other O(1)
     * Space: worst-case = O(n), other O(1)
     * 
     * @param item - new item to be appended.
     */
    public void append(T item)
    {
        // we need to resize the array
        if (this.length + 1 >= this.capacity)
        {
            this.capacity = this.capacity == 0 ? 1 : this.capacity * 2;     // double the capacity

            T[] new_array = (T[]) new Object[this.capacity];
            for (int i = 0; i < this.length; i++) new_array[i] = this.array[i];

            this.array = new_array;
        }

        this.array[this.length++] = item;
    }

    /**
     * Returns an item at the specified index.
     * Time:  O(1)
     * Space: O(1)
     * 
     * @param index - array index.
     * @return item a the specified index.
     */
    public T get(int index)
    {
        if (index >= this.length || index < 0) throw new IndexOutOfBoundsException();
        return this.array[index];
    }

    /**
     * Sets an itemt at the specified index.
     * Time:  O(1)
     * Space: O(1)
     * 
     * @param index - array index.
     * @param T - item to be set.
     */
    public void set(int index, T item)
    {
        if (index >= this.length || index < 0) throw new IndexOutOfBoundsException();
        this.array[index] = item;
    }

    /**
     * Clears an array.
     * Time:  O(n)
     * Space: O(1)
     */
    public void clear()
    {
        for (int index = 0; index < this.length; index++)
            this.array[index] = null;

        this.length = 0;
    }

    /**
     * Returns a dynamic array length.
     */
    public int length()
    {
        return this.length;
    }

    /**
     * Returns a dynamic array capacity.
     */
    public int capacity()
    {
        return this.capacity;
    }

    /**
     * Checks if an array is empty.
     */
    public boolean isEmpty()
    {
        return this.length == 0;
    }
}
