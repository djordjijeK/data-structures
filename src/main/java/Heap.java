public class Heap<T extends Comparable<T>>
{
    // a dynamic array to track the elements inside the heap.
    private DynamicArray<T> heap;

    // having this mapping lets us have O(log n) removals and O(1) 
    // element containment check at the cost of some additional space and minor overhead.
    private HashTable<T, HashSet<Integer>> map = new HashTable<>();

    /**
     * Heap constructor.
     */
    public Heap()
    {
        this(1);
    }

    /**
     * Heap constructor.
     * 
     * @param capacity - heap capacity.
     */
    public Heap(int capacity)
    {
        this.heap = new DynamicArray<>(capacity);
    }

    /**
     * Heap constructor.
     * 
     * @param elements - an array of elements to insert into a heap.
     */
    public Heap(T[] elements)
    {
        this.heap = new DynamicArray<>(elements.length);

        for (int i = 0; i < elements.length; i++)
        {
            this.updateMap(elements[i], i);
            this.heap.append(elements[i]);
        }

        for (int i = Math.max(0, (this.heap.length() / 2) - 1); i >= 0; i--)
            this.sink(i);
    }

    /**
     * Returns the minimum value in the heap.
     * If the priority queue is empty, the null is returned.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the minimum element in the heap.
     */
    public T peek() 
    {
        if (this.isEmpty())
            return null;

        return this.heap.get(0);
    }

    /**
     * Checks if an element is in the heap.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param element  - an element to look for.
     * @return boolean - true if an element exists, false otherwise.
     */
    public boolean contains(T element) 
    {
        if (element == null) 
            return false;

        return this.map.containsKey(element);
    }

    /**
     * Adds new element to the heap.
     * Time  Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param element - an element to be added to the heap.
     */
    public void add(T element) 
    {
        if (element == null) 
            throw new IllegalArgumentException();

        this.heap.append(element);
        int indexOfLastElem = this.size() - 1;

        this.updateMap(element, indexOfLastElem);
        this.swim(indexOfLastElem);
    }

    /**
     * Removes an element from the heap.
     * Time  Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param element  - an element to be removed from the heap.
     * @return boolean - true if an element is removed, false otherwise.
     */
    public boolean remove(T element) {

        if (element == null) 
            return false;
    
        Integer index = this.mapGet(element);

        if (index != null) 
            this.removeAt(index);

        return index != null;
    }

    /**
     * Removes an element at index.
     * Time  Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param index    - index of an element to remove.
     * @return boolean - removed element if exists, null otherwise.
     */
    private T removeAt(int index) 
    {
        if (this.isEmpty()) 
            return null;
    
        int indexOfLastElem = this.size() - 1;
        T removed_data = this.heap.get(index);
        this.swap(index, indexOfLastElem);
    
        // Obliterate the value
        this.heap.removeAt(indexOfLastElem);
        mapRemove(removed_data, indexOfLastElem);
    
        if (index == indexOfLastElem) 
            return removed_data;
    
        T element = this.heap.get(index);
    
        // Try sinking element
        this.sink(index);
    
        // If sinking did not work try swimming
        if (this.heap.get(index).equals(element)) 
            this.swim(index);
    
        return removed_data;
      }

    /**
     * Returns the heap size.
     */
    public int size()
    {
        return this.heap.length();
    }

    /**
     * Checks if the heap is empty.
     */
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    // method that checks if the structure is still maintaining the heap invariant.
    public boolean isMinHeap(int k) 
    {
        if (k >= this.heap.length()) 
            return true;

        int leftChildIndex  = 2 * k + 1;
        int rightChildIndex = 2 * k + 2;

        // make sure that the current node k is less than
        // both of its children left, and right if they exist
        if (leftChildIndex < this.heap.length() && !less(leftChildIndex, k)) 
            return false;
        if (rightChildIndex < this.heap.length() && !less(rightChildIndex, k)) 
            return false;

        // recurse on both children to make sure they're also valid heaps
        return this.isMinHeap(leftChildIndex) && this.isMinHeap(rightChildIndex);
    }

    /**
     * Clears the heap.
     */
    public void clear()
    {
        this.heap.clear();
        this.map.clear();
    }

    @Override
    public String toString() 
    {
        return this.heap.toString();
    }

    /********************** PRIVATE INTERFACE **********************/

    /**
     * Updates the map that represents our internal index.
     * Time  Complexity: worst-case O(n), other O(1)
     * Space Complexity: worst-case O(n), other O(1)
     * 
     * @param element - heap's element.
     * @param index   - element's new index.
     */
    private void updateMap(T element, int index)
    {
        HashSet<Integer> set = this.map.get(element);

        if (set == null)
        {
            set = new HashSet<>();
            set.add(index);

            this.map.insert(element, set);
        }
        else
        {
            set.add(index);
        }
    }

    /**
     * Updates the map that represents our internal index by swapping indices for swapping elements.
     */
    private void swapMap(T firstElement, T secondElement, int firstIndex, int secondIndex)
    {
        HashSet<Integer> firstSet  = this.map.get(firstElement);
        HashSet<Integer> secondSet = this.map.get(secondElement);
    
        firstSet.remove(firstIndex);
        secondSet.remove(secondIndex);
    
        firstSet.add(secondIndex);
        secondSet.add(firstIndex);
    }

    /**
     * Gets the value from the map that represents our internal index.
     */
    private Integer mapGet(T value) 
    {
        HashSet<Integer> set = this.map.get(value);

        if (set != null) 
        {
            Integer max = Integer.MIN_VALUE;

            for(Integer x : set)
            {
                if (x > max)
                    max = x;
            }

            return max;
        }

        return null;
    }

    private void mapRemove(T value, int index) 
    {
        HashSet<Integer> set = this.map.get(value);

        set.remove(index);

        if (set.size() == 0) 
            map.remove(value);
    }

    /**
     * Sinks the node to the correct position to satisfy the heap invariant.
     * Time  Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param rootIndex - index of an sinking element.
     */
    private void sink(int rootIndex)
    {
        while (true)
        {
            int leftChildIndex  = 2*rootIndex + 1;
            int rightChildIndex = 2*rootIndex + 2;
            
            int smallestIndex = leftChildIndex;

            if (rightChildIndex < this.heap.length() && this.less(leftChildIndex, rightChildIndex))
                smallestIndex = rightChildIndex;

            if (leftChildIndex >= this.heap.length() || this.less(smallestIndex, rootIndex)) 
                break;

            this.swap(rootIndex, smallestIndex);
            rootIndex = smallestIndex;
        }
    }

    /**
     * Swims the node to the correct position to satisfy the heap invariant.
     * Time  Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param rootIndex - index of an swimming element.
     */
    private void swim(int rootIndex)
    {
        int parent = (rootIndex - 1) / 2;

        while (rootIndex > 0 && this.less(parent, rootIndex))
        {
            this.swap(parent, rootIndex);

            rootIndex = parent;
            parent = (rootIndex - 1) / 2;
        }
    }

    /**
     * Determines whether the right child has lesser value than the left child.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param left     - an index of a left child.
     * @param right    - an index of a right child.
     * @return boolean - true if the right child is lesser than the left child, false otherwise. 
     */
    private boolean less(int left, int right)
    {
        T leftChild  = this.heap.get(left);
        T rightChild = this.heap.get(right);
        
        return rightChild.compareTo(leftChild) <= 0;
    }

    /**
     * Swaps two elements in a heap.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param left  - an index of a left child.
     * @param right - an index of a right child.
     */
    private void swap(int firstIndex, int secondIndex) {

        T firstElement  = this.heap.get(firstIndex);
        T secondElement = this.heap.get(secondIndex);

        heap.set(firstIndex, secondElement);
        heap.set(secondIndex, firstElement);

        this.swapMap(firstElement, secondElement, firstIndex, secondIndex);
    }
}
