import java.util.Iterator;

public class Queue<T> implements Iterable<T>
{
    private DoublyLinkedList<T> queue;    // linked list used in a queue manner.
    
    /**
     * Queue constructor.
     */
    public Queue()
    {
        this.queue = new DoublyLinkedList<T>();
    }

    /**
     * Queue constructor. Create a queue with an initial element.
     * 
     * @param item - an item to be queued.
     */
    public Queue(T item)
    {
        this.queue = new DoublyLinkedList<T>();
        this.queue.prepend(item);
    }

    /**
     * Enqueues a new element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param item - an item to be enqueued.
     */
    public void enqueue(T item)
    {
        this.queue.append(item);
    }

    /**
     * Enqueues a new element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param item - an item to be enqueued.
     */
    public void offer(T item)
    {
        this.enqueue(item);
    }

    /**
     * Polls an element from the front of the queue.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the polled item.
     */
    public T poll()
    {
        if (this.isEmpty()) 
            throw new RuntimeException("Queue is empty!");

        return this.queue.removeFirst();
    }

    /**
     * Peeks at the front of the queue without removing an element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the polled item.
     */
    public T peek()
    {
        if (this.isEmpty()) 
            throw new RuntimeException("Queue is empty!");
            
        return this.queue.peekFirst();
    }

    /**
     * Finds an index of a particular value in the queue.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param item - item to search for. 
     * @return int - index of an item if exists, -1 otherwise.
     */
    public int indexOf(T item)
    {
        return this.queue.indexOf(item);
    }

    /**
     * Checks if a queue is empty.
     */
    public boolean isEmpty()
    {
        return this.queue.length() == 0;
    }

    /**
     * Returns queue length.
     */
    public int length()
    {
        return this.queue.length();
    }

    @Override
    public Iterator<T> iterator() 
    {
        return this.queue.iterator();
    }

    @Override
    public String toString() 
    {
        return this.queue.toString();
    }
}
