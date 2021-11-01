import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class QueueTest 
{
    @Test
    public void testQueueConstructor()
    {
        var queue = new Queue<Integer>();

        Assertions.assertTrue(queue.isEmpty());
        Assertions.assertEquals(0, queue.length());
        
        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.poll();
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            queue.peek();
        });

        var newQueue = new Queue<Integer>(10);

        Assertions.assertFalse(newQueue.isEmpty());
        Assertions.assertEquals(1, newQueue.length());
        Assertions.assertEquals(10, newQueue.peek());
    } 
    
    @Test
    public void testEnqueue()
    {
        var queue = new Queue<Integer>();

        queue.enqueue(10);
        queue.offer(20);
        queue.enqueue(30);
        queue.offer(40);
        queue.enqueue(50);

        Assertions.assertEquals(5, queue.length());
        Assertions.assertEquals(10, queue.peek());
        Assertions.assertEquals(2, queue.indexOf(30));
        Assertions.assertEquals(-1, queue.indexOf(100));
    }

    @Test
    public void testPoll()
    {
        var queue = new Queue<String>();

        queue.offer("Djordjije");
        queue.offer("Bogdan");
        queue.offer("Snezana");

        Assertions.assertEquals(3, queue.length());

        Assertions.assertEquals("Djordjije", queue.poll());
        Assertions.assertEquals(2, queue.length());

        Assertions.assertEquals("Bogdan", queue.peek());
        Assertions.assertEquals("Bogdan", queue.poll());
        Assertions.assertEquals(1, queue.length());

        Assertions.assertEquals("Snezana", queue.poll());
        Assertions.assertEquals(0, queue.length());
        Assertions.assertTrue(queue.isEmpty());
    }
}
