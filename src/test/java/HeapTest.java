import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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

    @Test
    public void testHeapAdd()
    {
        Heap<Integer> heap = new Heap<>();

        heap.add(10);

        Assertions.assertEquals(1, heap.size());
        Assertions.assertEquals(10, heap.peek());

        heap.add(5);
        heap.add(7);

        Assertions.assertEquals(3, heap.size());
        Assertions.assertEquals(5, heap.peek());

        heap.add(1);

        Assertions.assertEquals(4, heap.size());
        Assertions.assertEquals(1, heap.peek());
        Assertions.assertTrue(heap.isMinHeap(0));
    }

    @Test
    public void testHeapRemove()
    {
        Heap<Integer> heap = new Heap<>();

        heap.add(10);
        heap.add(5);
        heap.add(7);
        heap.add(1);

        Assertions.assertEquals(4, heap.size());
        Assertions.assertEquals(1, heap.peek());
        Assertions.assertTrue(heap.isMinHeap(0));

        heap.remove(1);
        Assertions.assertEquals(5, heap.peek());
        Assertions.assertTrue(heap.isMinHeap(0));

        heap.remove(10);
        Assertions.assertTrue(heap.isMinHeap(0));
        heap.remove(5);
        Assertions.assertEquals(7, heap.peek());
        Assertions.assertTrue(heap.isMinHeap(0));

        heap.remove(7);
        Assertions.assertNull(heap.peek());
        Assertions.assertTrue(heap.isMinHeap(0));
    }
}
