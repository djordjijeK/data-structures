import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T>
{
    private T[] array;          // container
    private int length   = 0;   // current array length
    private int capacity = 0;   // array capacity

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
        if (capacity < 0) 
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        
        this.capacity = capacity;
        this.array    = (T[]) new Object[this.capacity];
    }

    /**
     * Appends a new element at the end of an array.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param element - new element to be appended.
     */
    public void append(T element)
    {
        // we need to resize the array ~ O(n)
        if (this.length + 1 >= this.capacity)
        {
            this.capacity = this.capacity == 0 ? 1 : this.capacity * 2;     // double the capacity

            T[] new_array = (T[]) new Object[this.capacity];
            for (int i = 0; i < this.length; i++)
                new_array[i] = this.array[i];

            this.array = new_array;
        }

        this.array[this.length++] = element;
    }

    /**
     * Returns the index of an element in the array.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param element - element in the array.
     * @return int    - index of the element in the array if exists, -1 otherwise.
     */
    public int indexOf(T element)
    {
        for (int index = 0; index < this.length(); index++)
        {
            if (element == null) 
            {
                if (this.array[index] == null) 
                    return index;
            }
            else
            {
                if (element.equals(this.array[index])) 
                    return index;
            }
        }

        return -1;
    }

    /**
     * Removes an element from the specified index.
     * Time  Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param index - array index.
     * @return T    - removed element at the specified index.
     */
    public T removeAt(int index)
    {
        if (index >= this.length || index < 0) 
            throw new IndexOutOfBoundsException();

        T data        = this.array[index];
        T[] new_array = (T[]) new Object[this.length - 1];
        
        for (int i = 0, j = 0; i < this.length(); i++, j++)
        {
            if (i == index) 
                j--;
            else 
                new_array[j] = this.array[i];
        }

        this.capacity = --this.length;
        this.array    = new_array;

        return data;
    }

    /**
     * Removes an element from an array.
     * Time  Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param element  - element in the array.
     * @return boolean - true if element is removed, false otherwise.
     */
    public boolean remove(T element)
    {
        int index = this.indexOf(element);

        if (index == -1) 
            return false;
        
        this.removeAt(index);

        return true;
    }

    /**
     * Checks if an element exists in the array.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param element  - element in the array.
     * @return boolean - true if element exists, false otherwise.
     */
    public boolean contains(T element)
    {
        return this.indexOf(element) != -1;
    }

    /**
     * Returns an element at the specified index.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param index - array index.
     * @return T    - element at the specified index.
     */
    public T get(int index)
    {
        if (index >= this.length || index < 0) 
            throw new IndexOutOfBoundsException();

        return this.array[index];
    }

    /**
     * Sets an element at the specified index.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param index   - array index.
     * @param element - element to be set.
     */
    public void set(int index, T element)
    {
        if (index >= this.length || index < 0) 
            throw new IndexOutOfBoundsException();

        this.array[index] = element;
    }

    /**
     * Clears the array.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void clear()
    {
        for (int index = 0; index < this.length; index++)
            this.array[index] = null;

        this.length = 0;
    }

    /**
     * DynamicArray length.
     */
    public int length()
    {
        return this.length;
    }

    /**
     * DynamicArray capacity.
     */
    public int capacity()
    {
        return this.capacity;
    }

    /**
     * Checks if the array is empty.
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

    /**
     * DynamicArray class string representation.
     */
    @Override
    public String toString() 
    {
        if (this.length() == 0) 
            return "[]";
        else
        {
            StringBuilder builder = new StringBuilder(this.length()).append("[");

            for(int index = 0; index < this.length() - 1; index++)
            {
                builder.append(this.array[index]).append(",");
            }

            builder.append(this.array[this.length() - 1]).append("]");
            return builder.toString();
        }    
    }
}
