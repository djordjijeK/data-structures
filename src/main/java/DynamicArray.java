import java.util.Iterator;

/**
 * Generic dynamic array data structure implementation.
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>
{
    private T[] array;          // container
    private int length   = 0;   // current array length
    private int capacity = 0;   // array capcity

    /**
     * DynamicArray constructor.
     */
    public DynamicArray()
    {
        this(16);
    }

    /**
     * DynamicArray constructor.
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
     * Time:  worst-case O(n), other O(1)
     * Space: worst-case O(n), other O(1)
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
     * Returns index of an item in the array.
     * Time:  O(n)
     * Space: O(1)
     * 
     * @param item - item in the array.
     * @return index of an item in the array if exists, -1 otherwise.
     */
    public int indexOf(T item)
    {
        for (int index = 0; index < this.length(); index++)
        {
            if (item == null) 
            {
                if (this.array[index] == null) return index;
            }
            else
            {
                if (item.equals(this.array[index])) return index;
            }
        }

        return -1;
    }

    /**
     * Removes an item from the specified index.
     * Time:  O(n)
     * Space: O(n)
     * 
     * @param index - array index.
     * @return removed item at the specified index.
     */
    public T removeAt(int index)
    {
        if (index >= this.length || index < 0) throw new IndexOutOfBoundsException();

        T data = this.array[index];
        T[] new_array = (T[]) new Object[this.length - 1];
        
        for (int i = 0, j = 0; i < this.length(); i++, j++)
        {
            if (i == index) j--;
            else new_array[j] = this.array[i];
        }

        this.capacity = --this.length;
        this.array  = new_array;

        return data;
    }

    /**
     * Removes an item from an array.
     * Time:  O(n)
     * Space: O(n)
     * 
     * @param item - item in the array.
     * @return true if item is removed, false otherwise.
     */
    public boolean remove(T item)
    {
        int index = this.indexOf(item);

        if (index == -1) return false;
        
        this.removeAt(index);
        
        return true;
    }

    /**
     * Checks if an item exists in an array.
     * Time:  O(n)
     * Space: O(1)
     * 
     * @param item - item in the array.
     * @return true if item exists, false otherwise.
     */
    public boolean contains(T item)
    {
        return this.indexOf(item) != -1;
    }

    /**
     * Returns an item at the specified index.
     * Time:  O(1)
     * Space: O(1)
     * 
     * @param index - array index.
     * @return item at the specified index.
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

    @Override
    public Iterator<T> iterator() 
    {
        return new Iterator<T>()
        {
            int index = 0;

            @Override
            public boolean hasNext() 
            {
                return index < length();    
            }

            @Override
            public T next() 
            {
                return array[index++];    
            }

            @Override
            public void remove() 
            {
                throw new UnsupportedOperationException();   
            }
        };  
    }

    @Override
    public String toString() 
    {
        if (this.length() == 0) return "[]";
        else
        {
            var builder = new StringBuilder(this.length()).append("[");

            for(int index = 0; index < this.length() - 1; index++)
            {
                builder.append(this.array[index] + ",");
            }

            builder.append(this.array[this.length() - 1] + "]");
            return builder.toString();
        }    
    }
}
