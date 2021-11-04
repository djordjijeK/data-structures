import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HashSetTest 
{
    @Test
    public void testHashSetConstructor()
    {
        HashSet<String> set = new HashSet<>();

        Assertions.assertTrue(set.isEmpty());
        Assertions.assertEquals(0, set.size());
    }

    @Test
    public void testHashSetAdd()
    {
        HashSet<String> set = new HashSet<>();

        Assertions.assertTrue(set.add("Bogdan"));
        Assertions.assertTrue(set.add("Djordjije"));

        Assertions.assertFalse(set.isEmpty());
        Assertions.assertEquals(2, set.size());

        Assertions.assertFalse(set.add("Bogdan"));
        Assertions.assertFalse(set.add("Djordjije"));

        Assertions.assertFalse(set.isEmpty());
        Assertions.assertEquals(2, set.size());
    }

    @Test
    public void testHashSetContains()
    {
        HashSet<String> set = new HashSet<>();

        set.add("Djordjije");
        set.add("Bogdan");
        set.add("Vesna");
        set.add("Petar");
        set.add("Janko");

        Assertions.assertTrue(set.contains("Bogdan"));
        Assertions.assertTrue(set.contains("Djordjije"));
        Assertions.assertFalse(set.contains("subo"));
        Assertions.assertFalse(set.contains("Marko"));
    }

    @Test
    public void testHashSetRemove()
    {
        HashSet<String> set = new HashSet<>();

        set.add("Djordjije");
        set.add("Bogdan");
        set.add("Vesna");

        Assertions.assertEquals(3, set.size());

        set.remove("Djordjije");

        Assertions.assertEquals(2, set.size());
        Assertions.assertFalse(set.contains("Djordjije"));

        set.remove("Vesna");
        set.remove("Bogdan");

        Assertions.assertTrue(set.isEmpty());
    }
}
