import org.junit.jupiter.api.Test;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Assertions;

public class StackTest 
{
    @Test
    public void testStackConstructor()
    {
        var stack = new Stack<Integer>();

        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.length());
        
        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });

        Assertions.assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        });

        var newStack = new Stack<Integer>(10);

        Assertions.assertFalse(newStack.isEmpty());
        Assertions.assertEquals(1, newStack.length());
        Assertions.assertEquals(10, newStack.peek());
    }

    @Test
    public void testStackPush()
    {
        var stack = new Stack<Integer>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        Assertions.assertEquals(5, stack.length());
        Assertions.assertEquals(50, stack.peek());
        Assertions.assertEquals(2, stack.indexOf(30));
        Assertions.assertEquals(-1, stack.indexOf(100));
    }

    @Test
    public void testStackPop()
    {
        var stack = new Stack<String>();

        stack.push("Djordjije");
        stack.push("Bogdan");
        stack.push("Snezana");

        Assertions.assertEquals(3, stack.length());

        Assertions.assertEquals("Snezana", stack.pop());
        Assertions.assertEquals(2, stack.length());

        Assertions.assertEquals("Bogdan", stack.peek());
        Assertions.assertEquals("Bogdan", stack.pop());
        Assertions.assertEquals(1, stack.length());

        Assertions.assertEquals("Djordjije", stack.pop());
        Assertions.assertEquals(0, stack.length());
        Assertions.assertTrue(stack.isEmpty());
    }
}
