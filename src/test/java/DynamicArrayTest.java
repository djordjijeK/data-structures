import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

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
}
