import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DoublyLinkedListTest
{
    @Test
    public void testDefaultConstructor()
    {
        var linkedList = new DoublyLinkedList<>();

        Assertions.assertTrue(linkedList.isEmpty());
        Assertions.assertEquals(0, linkedList.length());
        
        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekFirst();
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekLast();
        });
    }

    @Test
    public void testAppend()
    {
        var linkedList = new DoublyLinkedList<String>();

        linkedList.append("Djordjije");

        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals("Djordjije", linkedList.peekFirst());
        Assertions.assertEquals("Djordjije", linkedList.peekLast());

        linkedList.add("Vesna");
        linkedList.append("Bogdan");

        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals("Djordjije", linkedList.peekFirst());
        Assertions.assertEquals("Bogdan", linkedList.peekLast());
    }

    @Test
    public void testPrepend()
    {
        var linkedList = new DoublyLinkedList<Integer>();

        linkedList.prepend(100);

        Assertions.assertFalse(linkedList.isEmpty());
        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals(100, linkedList.peekFirst());
        Assertions.assertEquals(100, linkedList.peekLast());

        linkedList.prepend(200);
        linkedList.prepend(300);

        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals(300, linkedList.peekFirst());
        Assertions.assertEquals(100, linkedList.peekLast());
    }

    @Test
    public void testInsertAt()
    {
        var linkedList = new DoublyLinkedList<Integer>();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.insertAt(1, 100);
        });

        linkedList.insertAt(0, 100);
        linkedList.insertAt(1, 200);

        Assertions.assertEquals(2, linkedList.length());
        Assertions.assertEquals(100, linkedList.peekFirst());
        Assertions.assertEquals(200, linkedList.peekLast());

        linkedList.insertAt(2, 300);
        linkedList.insertAt(3, 400);
        linkedList.insertAt(4, 600);
        linkedList.insertAt(4, 500);

        Assertions.assertEquals(6, linkedList.length());

        for (int index = 0; index < linkedList.length(); index++)
            Assertions.assertEquals((index + 1) * 100, linkedList.get(index));

        linkedList.insertAt(1, 1000);
        linkedList.insertAt(2, 2000);
        linkedList.insertAt(5, 3000);

        Assertions.assertEquals(1000, linkedList.get(1));
        Assertions.assertEquals(2000, linkedList.get(2));
        Assertions.assertEquals(3000, linkedList.get(5));
    }

    @Test
    public void testRemoveFirst()
    {
        var linkedList = new DoublyLinkedList<Character>();

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.removeFirst();
        });

        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append('D');

        linkedList.removeFirst();

        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals('B', linkedList.peekFirst());
        Assertions.assertEquals('D', linkedList.peekLast());

        linkedList.removeFirst();
        linkedList.removeFirst();

        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals('D', linkedList.peekFirst());
        Assertions.assertEquals('D', linkedList.peekLast());

        linkedList.removeFirst();

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekFirst();
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekLast();
        });

        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testRemoveLast()
    {
        var linkedList = new DoublyLinkedList<Character>();

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.removeFirst();
        });

        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append('D');

        linkedList.removeLast();

        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals('A', linkedList.peekFirst());
        Assertions.assertEquals('C', linkedList.peekLast());

        linkedList.removeLast();
        linkedList.removeLast();

        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals('A', linkedList.peekFirst());
        Assertions.assertEquals('A', linkedList.peekLast());

        linkedList.removeLast();

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekFirst();
        });

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.peekLast();
        });

        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testRemoveAt()
    {
        var linkedList = new DoublyLinkedList<Character>();

        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append('D');
        linkedList.append('E');

        Assertions.assertThrows(RuntimeException.class, () -> {
            linkedList.removeAt(5);
        });

        linkedList.removeAt(2);

        Assertions.assertEquals(4, linkedList.length());
        Assertions.assertEquals('A', linkedList.get(0));
        Assertions.assertEquals('B', linkedList.get(1));
        Assertions.assertEquals('D', linkedList.get(2));
        Assertions.assertEquals('E', linkedList.get(3));

        linkedList.removeAt(1);

        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals('A', linkedList.get(0));
        Assertions.assertEquals('D', linkedList.get(1));
        Assertions.assertEquals('E', linkedList.get(2));

        linkedList.removeAt(0);
        linkedList.removeAt(linkedList.length() - 1);

        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals('D', linkedList.peekFirst());
        Assertions.assertEquals('D', linkedList.peekLast());
    }

    @Test
    public void testRemove()
    {
        var linkedList = new DoublyLinkedList<Character>();

        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append(null);
        linkedList.append('D');

        boolean result = linkedList.remove('C');
        
        Assertions.assertTrue(result);
        Assertions.assertEquals(4, linkedList.length());
        Assertions.assertEquals('A', linkedList.get(0));
        Assertions.assertEquals('B', linkedList.get(1));
        Assertions.assertEquals(null, linkedList.get(2));
        Assertions.assertEquals('D', linkedList.get(3));

        result = linkedList.remove('C');

        Assertions.assertFalse(result);
        Assertions.assertEquals(4, linkedList.length());

        result = linkedList.remove(null);

        Assertions.assertTrue(result);
        Assertions.assertEquals(3, linkedList.length());
        Assertions.assertEquals('A', linkedList.get(0));
        Assertions.assertEquals('B', linkedList.get(1));
        Assertions.assertEquals('D', linkedList.get(2));

        linkedList.remove('A');
        linkedList.remove('D');

        Assertions.assertEquals(1, linkedList.length());
        Assertions.assertEquals('B', linkedList.peekFirst());
        Assertions.assertEquals('B', linkedList.peekLast());
    }

    @Test
    public void testIndexOfAndContains()
    {
        var linkedList = new DoublyLinkedList<Character>();

        linkedList.append('A');
        linkedList.append('B');
        linkedList.append('C');
        linkedList.append(null);
        linkedList.append('D');

        Assertions.assertEquals(0, linkedList.indexOf('A'));
        Assertions.assertEquals(3, linkedList.indexOf(null));
        Assertions.assertEquals(-1, linkedList.indexOf('E'));

        Assertions.assertTrue(linkedList.contains('D'));
        Assertions.assertFalse(linkedList.contains('F'));
    }

}
