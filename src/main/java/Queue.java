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
     * @param element - an element to be queued.
     */
    public Queue(T element)
    {
        this.queue = new DoublyLinkedList<T>();
        this.queue.prepend(element);
    }

    /**
     * Enqueues a new element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param element - an element to be enqueued.
     */
    public void enqueue(T element)
    {
        this.queue.append(element);
    }

    /**
     * Enqueues a new element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param element - an element to be enqueued.
     */
    public void offer(T element)
    {
        this.enqueue(element);
    }

    /**
     * Polls an element from the front of the queue.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the polled element.
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
     * @return T - the peeked element.
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
     * @param element - an element to search for. 
     * @return int    - index of an element if exists, -1 otherwise.
     */
    public int indexOf(T element)
    {
        return this.queue.indexOf(element);
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

    /**
     * Queue class string representation.
     */
    @Override
    public String toString() 
    {
        return this.queue.toString();
    }
}
