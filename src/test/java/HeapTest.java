import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapTest 
{
    @Test
    public void testHeapConstructorI()
    {
        Heap<Integer> heap = new Heap<>(new Integer[]{10});

        Assertions.assertEquals(1, heap.size());
        Assertions.assertTrue(heap.isMinHeap(0));
    }

    @Test
    public void testHeapConstructorII()
    {
        Heap<Integer> heap = new Heap<>(new Integer[]{10, 5});

        Assertions.assertEquals(2, heap.size());
        Assertions.assertTrue(heap.isMinHeap(0));
    }

    @Test
    public void testHeapConstructorIII()
    {
        Heap<Integer> heap = new Heap<>(new Integer[]{});

        Assertions.assertEquals(0, heap.size());
        Assertions.assertTrue(heap.isMinHeap(0));
    }

    @Test
    public void testHeapConstructorIV()
    {
        Heap<Integer> heap = new Heap<>(new Integer[]{10, 5, 15, 2, 7});

        Assertions.assertFalse(heap.isEmpty());
        Assertions.assertEquals(5, heap.size());
        Assertions.assertTrue(heap.isMinHeap(0));
    }
    
    
}
