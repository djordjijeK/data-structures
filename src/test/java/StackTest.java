import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.EmptyStackException;

public class StackTest 
{
    @Test
    public void testStackConstructor()
    {
        Stack<Integer> stack = new Stack<>();

        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertEquals(0, stack.length());
        
        Assertions.assertThrows(EmptyStackException.class, stack::pop);

        Assertions.assertThrows(EmptyStackException.class, stack::peek);

        Stack<Integer> newStack = new Stack<>(10);

        Assertions.assertFalse(newStack.isEmpty());
        Assertions.assertEquals(1, newStack.length());
        Assertions.assertEquals(10, newStack.peek());
    }

    @Test
    public void testStackPush()
    {
        Stack<Integer> stack = new Stack<>();

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
        Stack<String> stack = new Stack<>();

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
