/**
 * Generic doubly linked list data structure implementation.
 */
@SuppressWarnings("unchecked")
public class DoublyLinkedList<T>
{
    private int size = 0;           // linked list size
    private Node<T> head = null;    // head of a linked list
    private Node<T> tail = null;    // tail of a linked list

    /**
     * Internal class that represents one node in a doubly linked list.
     */
    private class Node<T>
    {
        private T key;
        private Node<T> previous, next;

        /**
         * Node class constructor.
         * 
         * @param key      - node's key.
         * @param previous - previous node in a list.
         * @param next     - next node in a list.
         */
        public Node<T>(T key, Node<T> previous, Node<T> next)
        {
            this.key      = key;
            this.previous = previous;
            this.next     = next;
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
}
