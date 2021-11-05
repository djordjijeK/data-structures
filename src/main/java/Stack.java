import java.util.Iterator;
import java.util.EmptyStackException;

public class Stack<T> implements Iterable<T>
{
    private DoublyLinkedList<T> stack;    // linked list used in a stack manner.
    
    /**
     * Stack constructor.
     */
    public Stack()
    {
        this.stack = new DoublyLinkedList<T>();
    }

    /**
     * Stack constructor. Create a stack with an initial element.
     * 
     * @param element - an element to be pushed on the stack.
     */
    public Stack(T element)
    {
        this.stack = new DoublyLinkedList<T>();
        this.stack.prepend(element);
    }

    /**
     * Pushes a new element on the stack.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @param element - an element to be pushed on the stack.
     */
    public void push(T element)
    {
        this.stack.prepend(element);
    }

    /**
     * Pops an element from the top of the stack.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the popped element.
     */
    public T pop()
    {
        if (this.isEmpty()) 
            throw new EmptyStackException();

        return this.stack.removeFirst();
    }

    /**
     * Peeks at the top of the stack without removing an element.
     * Time  Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return T - the value of an element at the top of the stack.
     */
    public T peek()
    {
        if (this.isEmpty()) 
            throw new EmptyStackException();
            
        return this.stack.peekFirst();
    }

    /**
     * Finds an index of a particular value stored on the stack.
     * Time  Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param element - an element to search for. 
     * @return int    - index of an element if exists, -1 otherwise.
     */
    public int indexOf(T element)
    {
        return this.stack.indexOf(element);
    }

    /**
     * Returns stack length.
     */
    public int length()
    {
        return this.stack.length();
    }

    /**
     * Checks if a stack is empty.
     */
    public boolean isEmpty()
    {
        return this.stack.length() == 0;
    }

    @Override
    public Iterator<T> iterator() 
    {
        return this.stack.iterator();
    }

    /**
     * Stack class string representation.
     */
    @Override
    public String toString() 
    {
        return this.stack.toString();
    }
}
