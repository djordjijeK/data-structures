public class DoublyLinkedList<T>
{
    private int size;        // linked list size
    private Node<T> head;    // head of a linked list
    private Node<T> tail;    // tail of a linked list

    /**
     * Internal class that represents one node in a doubly linked list.
     */
    private static class Node<T>
    {
        private T key;
        private Node<T> previous, next;

        /**
         * Node class constructor.
         * 
         * @param key      - node's key.
         * @param previous - the previous node in a list.
         * @param next     - the next node in a list.
         */
        public Node(T key, Node<T> previous, Node<T> next)
        {
            this.key      = key;
            this.previous = previous;
            this.next     = next;
        }

        /**
         * Node class constructor.
         * 
         * @param key - node's key.
         */
        public Node(T key)
        {
            this.key      = key;
            this.previous = null;
            this.next     = null;
        }

        /**
         * Node class string representation.
         */
        @Override
        public String toString()
        {
            return this.key.toString();
        }
    }

    /**
     * DoublyLinkedList constructor.
     */
    public DoublyLinkedList()
    {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Adds a new item at the end of a linked list.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param item - new item to be appended.
     */
    public void add(T item)
    {
        this.append(item);
    }

    /**
     * Appends a new item at the end of a linked list.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param item - new item to be appended.
     */
    public void append(T item)
    {
        if (this.isEmpty())
        {
            this.head = this.tail = new Node<T>(item);
        }
        else
        {
            this.tail.next = new Node<T>(item, this.tail, null);
            this.tail      = this.tail.next;
        }

        this.size++;
    }

    /**
     * Adds a new item at the beginning of a linked list.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param item - new item to be prepended.
     */
    public void prepend(T item)
    {
        if (this.isEmpty())
        {
            this.head = this.tail = new Node<T>(item);
        }
        else
        {
            this.head.previous = new Node<T>(item, null, this.head);
            this.head = this.head.previous;
        }

        this.size++;
    }

    /**
     * Adds a new item in a linked list at the specified index.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param index - an index to insert a new item. 
     * @param item  - new item to be inserted.
     */
    public void insertAt(int index, T item) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > this.length())
            throw new IndexOutOfBoundsException();

        if (index == 0)
        {
            this.prepend(item);
            return;
        } 
        
        if (index == this.length())
        {
            this.append(item);
            return;
        }

        Node<T> temp = this.head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        Node<T> newNode = new Node<T>(item, temp, temp.next);
        temp.next.previous = newNode;
        temp.next = newNode;

        this.size++;
    }

    /**
     * Removes an item in a linked list at the specified index.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param index - an index to remove an item. 
     * @return T    - an item at the specified index.
     */
    public T removeAt(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= this.length())
            throw new IndexOutOfBoundsException();

        if (index == 0) 
            return this.removeFirst();

        if (index == this.length() - 1)
            return this.removeLast();

        int i;
        Node<T> current;

        if (index - 1 <= this.length() / 2)
        {
            for(i = 0, current = this.head; i != index - 1; i++)
                current = current.next;
        }
        else
        {
            for(i = this.length() - 1, current = this.tail; i != index - 1; i--)
                current = current.previous;
        }

        Node<T> removingNode = current.next;

        current.next = removingNode.next;
        removingNode.next.previous = current;

        removingNode.next = removingNode.previous = null;

        this.size = this.size - 1;

        return removingNode.key;
    }

    /**
     * Removes a particular value from a linked list if exists.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param object   - an object to be removed.
     * @return boolean - true if object is removed, false otherwise. 
     */
    public boolean remove(T value)
    {
        Node<T> current = this.head;

        if (value == null)
        {
            for(int index = 0; index < this.length(); index++)
            {
                
                if (current.key == null)
                {
                    this.removeAt(index);
                    return true;
                }
    
                current = current.next;
            }
        }
        else
        {
            for(int index = 0; index < this.length(); index++)
            {
                
                if (current.key != null && current.key.equals(value))
                {
                    this.removeAt(index);
                    return true;
                }
    
                current = current.next;
            }
        }

        return false;
    }

    /**
     * Returns an item at the specified index.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param index - item's index.
     * @return T    - an item at the specified index.
     */
    public T get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > this.length())
            throw new IndexOutOfBoundsException();

        Node<T> temp = this.head;

        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.key;
    }

    /**
     * Returns the value of the first node if exists.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the value of the first node.
     */
    public T peekFirst()
    {
        if (this.isEmpty()) throw new RuntimeException("Linked list is empty!");
        return this.head.key;
    }

    /**
     * Removes the head of the linked list.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the value of the first node.
     */
    public T removeFirst()
    {
        if (this.isEmpty()) throw new RuntimeException("Linked list is empty!");

        T key     = this.head.key;
        this.head = this.head.next;
        this.size = this.size - 1;

        if (this.isEmpty()) this.tail = null;
        else this.head.previous = null;

        return key;
    }

    /**
     * Returns the value of the last node if exists.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the value of the last node.
     */
    public T peekLast()
    {
        if (this.isEmpty()) throw new RuntimeException("Linked list is empty!");
        return this.tail.key;
    }

    /**
     * Removes the tail of the linked list.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the value of the last node.
     */
    public T removeLast()
    {
        if (this.isEmpty()) throw new RuntimeException("Linked list is empty!");

        T key     = this.tail.key;
        this.tail = this.tail.previous;
        this.size = this.size - 1;

        if (this.isEmpty()) this.head = null;
        else this.tail.next = null;

        return key;
    }

    /**
     * Returns linked list length.
     */
    public int length()
    {
        return this.size;
    }

    /**
     * Checks if a linked list is empty.
     */
    public boolean isEmpty()
    {
        return this.length() == 0;
    }
}
