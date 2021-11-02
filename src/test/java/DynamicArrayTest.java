import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Iterator;

public class DynamicArrayTest 
{
    @Test
    public void testDefaultConstructor()
    {
        var array = new DynamicArray<String>();

        Assertions.assertTrue(array.isEmpty());
        Assertions.assertEquals(0, array.length());
        Assertions.assertEquals(16, array.capacity());
    }

    @Test
    public void testConstructorPart1()
    {
        var array = new DynamicArray<String>(10);

        Assertions.assertTrue(array.isEmpty());
        Assertions.assertEquals(0, array.length());
        Assertions.assertEquals(10, array.capacity());
    }

    @Test
    public void testConstructorPart2()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            var array = new DynamicArray<Integer>(-10);
            array.append(10);
        });
    }

    @Test
    public void testAppend()
    {
        var array = new DynamicArray<Integer>();
        int[] data = {12, 27, -32, 47, 52};

        for (var item : data) array.append(item);

        for (int index = 0; index < array.length(); index++)
        {
            Assertions.assertEquals(data[index], array.get(index));
        }

        Assertions.assertEquals(data.length, array.length());
    }

    @Test
    public void testAppendResize()
    {
        var array = new DynamicArray<String>(2);

        Assertions.assertEquals(0, array.length());
        Assertions.assertEquals(2, array.capacity());

        array.append("Djordjije");
        array.append("Bogdan");

        Assertions.assertEquals(2, array.length());
        Assertions.assertEquals(4, array.capacity());

        array.append("Vesna");

        Assertions.assertEquals(3, array.length());
        Assertions.assertEquals(4, array.capacity());

        array.append("Petar");

        Assertions.assertEquals(4, array.length());
        Assertions.assertEquals(8, array.capacity());

        Assertions.assertEquals("Djordjije", array.get(0));
        Assertions.assertEquals("Bogdan", array.get(1));
        Assertions.assertEquals("Vesna", array.get(2));
        Assertions.assertEquals("Petar", array.get(3));
    }

    @Test
    public void testGet()
    {
        var array = new DynamicArray<String>();
        String[] data = {"ABC", "DEF", "GHI", "JKL"};
        
        for(String item : data) array.append(item);

        Assertions.assertEquals("DEF", array.get(1));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(-1);
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.get(5);
        });
    }

    @Test
    public void testSet()
    {
        var array = new DynamicArray<String>();
        String[] data = {"ABC", "DEF", "GHI", "JKL"};
        
        for(String item : data) array.append(item);

        array.set(2, "Puck");
        Assertions.assertEquals("Puck", array.get(2));
        
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.set(-1, "SingSing");
        });

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            array.set(5, "Dota2");
        });
    }

    @Test
    public void testClear()
    {
        var array = new DynamicArray<String>();
        String[] data = {"ABC", "DEF", "GHI", "JKL"};

        for(String item : data) array.append(item);

        array.clear();

        for (int index = 0; index < array.length(); index++)
        {
            Assertions.assertEquals(null, array.get(index));
        }
    }

    @Test
    public void testIndexOf()
    {
        var array = new DynamicArray<String>();
        String[] data = {"ABC", "DEF", "GHI", "JKL"};

        for(String item : data) array.append(item);

        Assertions.assertEquals(1, array.indexOf("DEF"));
        Assertions.assertEquals(3, array.indexOf("JKL"));
        Assertions.assertEquals(-1, array.indexOf("Djordjije"));
    }

    @Test
    public void testRemoteAt()
    {
        var array = new DynamicArray<Integer>();
        int[] data = {10, -15, 20, -25, 35, 75, 55, -35};

        for(Integer item : data) array.append(item); 

        var item = array.removeAt(0);

        Assertions.assertEquals(10, item);
        Assertions.assertEquals(data.length - 1, array.length());
        
        item = array.removeAt(0);

        Assertions.assertEquals(-15, item);
        Assertions.assertEquals(data.length - 2, array.length());

        item = array.removeAt(data.length - 3);

        Assertions.assertEquals(-35, item);
        Assertions.assertEquals(data.length - 3, array.length());
        Assertions.assertEquals(data.length - 3, array.capacity());
    }

    @Test
    public void testRemove()
    {
        var array = new DynamicArray<Integer>();
        int[] data = {10, -15, 20, -25, 35, 75, 55, -35};

        for(Integer item : data) array.append(item); 

        var truth = array.remove(10);

        Assertions.assertEquals(true, truth);
        Assertions.assertEquals(data.length - 1, array.length());

        truth = array.remove(100);

        Assertions.assertEquals(false, truth);
        Assertions.assertEquals(data.length - 1, array.length());

        truth = array.remove(75);

        Assertions.assertEquals(true, truth);
        Assertions.assertEquals(data.length - 2, array.length());
        Assertions.assertEquals(data.length - 2, array.capacity());
    }

    @Test
    public void testIterator()
    {
        var array = new DynamicArray<Integer>();
        int[] data = {10, -15, 20, -25, 35, 75, 55, -35};

        for(Integer item : data) array.append(item);

        int index = 0;
        Iterator<Integer> iter = array.iterator();

        while(iter.hasNext())
        {
            Assertions.assertEquals(iter.next(), data[index++]);
        }

        Assertions.assertEquals(index, data.length);
        index = 0;

        for(Integer number : array)
        {
            Assertions.assertEquals(number, data[index++]);
        }
    }
}
