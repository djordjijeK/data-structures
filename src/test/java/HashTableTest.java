import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class HashTableTest 
{
    @Test
    public void testHashTableDefaultConstructor()
    {
        HashTable<String, Integer> hashTable = new HashTable<>();

        Assertions.assertEquals(25, hashTable.getCapacity());
        Assertions.assertEquals(0.7, hashTable.getLoadFactor());
    }
    
    @Test
    public void testHashTableCapacityConstructor()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(7);

        Assertions.assertEquals(7, hashTable.getCapacity());
        Assertions.assertEquals(0.7, hashTable.getLoadFactor());
    }

    @Test
    public void testHashTableCapacityAndLoadFactorConstructor()
    {
        HashTable<String, Integer> hashTableFirst = new HashTable<>(7, 0.8);

        Assertions.assertEquals(7, hashTableFirst.getCapacity());
        Assertions.assertEquals(0.8, hashTableFirst.getLoadFactor());

        HashTable<String, Integer> hashTableSecond = new HashTable<>(7, 0.5);

        Assertions.assertEquals(7, hashTableSecond.getCapacity());
        Assertions.assertEquals(0.7, hashTableSecond.getLoadFactor());

        HashTable<String, Integer> hashTableThird = new HashTable<>(34, 0.5);

        Assertions.assertEquals(35, hashTableThird.getCapacity());
        Assertions.assertEquals(0.7, hashTableThird.getLoadFactor());
    }

    @Test
    public void testHashTableInsert()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2, 0.8);

        Assertions.assertTrue(hashTable.isEmpty());
    
        Integer oldValue = hashTable.insert("Djordjije", 27);

        Assertions.assertEquals(1, hashTable.size());
        Assertions.assertEquals(2, hashTable.getCapacity());
        Assertions.assertEquals(null, oldValue);

        oldValue = hashTable.put("Djordjije", 25);

        Assertions.assertEquals(1, hashTable.size());
        Assertions.assertEquals(5, hashTable.getCapacity());
        Assertions.assertEquals(27, oldValue);

        hashTable.add("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);

        Assertions.assertEquals(4, hashTable.size());
        Assertions.assertEquals(5, hashTable.getCapacity());

        hashTable.insert("Marko", 27);

        Assertions.assertEquals(5, hashTable.size());
        Assertions.assertEquals(11, hashTable.getCapacity());
    }

    @Test
    public void testHashTableGet()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.insert("Djordjije", 27);
        hashTable.put("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);
        hashTable.insert("Marko", 27);

        Assertions.assertEquals(27, hashTable.get("Djordjije"));
        Assertions.assertEquals(30, hashTable.get("Bogdan"));
        Assertions.assertEquals(null, hashTable.get("Subo"));
    }

    @Test
    public void testHashTableRemove()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.insert("Djordjije", 27);
        hashTable.put("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);
        hashTable.insert("Marko", 27);

        Integer oldValue = hashTable.remove("Djordjije");
        Assertions.assertEquals(27, oldValue);

        oldValue = hashTable.remove("Bogdan");
        Assertions.assertEquals(30, oldValue);

        Assertions.assertEquals(11, hashTable.getCapacity());
        Assertions.assertEquals(3, hashTable.size());
        Assertions.assertNull(hashTable.get("Djordjije"));
        Assertions.assertNull(hashTable.get("Bogdan"));
    }

    @Test
    public void testHashTableHasKey()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.insert("Djordjije", 27);
        hashTable.put("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);
        hashTable.insert("Marko", 27);

        Assertions.assertTrue(hashTable.hasKey("Vesna"));
        Assertions.assertFalse(hashTable.containsKey("Subo"));
    }

    @Test
    public void testHashTableClear()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.insert("Djordjije", 27);
        hashTable.put("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);
        hashTable.insert("Marko", 27);

        Assertions.assertEquals(5, hashTable.size());

        List<String> keys    = hashTable.keys();
        List<Integer> values = hashTable.values();

        for(int i = 0; i < hashTable.size(); i++)
        {
            Assertions.assertEquals(values.get(i), hashTable.get(keys.get(i)));
        }

        hashTable.clear();

        keys   = hashTable.keys();
        values = hashTable.values();

        for(int i = 0; i < hashTable.size(); i++)
        {
            Assertions.assertEquals(null, keys.get(i));
            Assertions.assertEquals(null, values.get(i));
        }
    }

    @Test
    public void testHashTableIterations()
    {
        HashTable<String, Integer> hashTable = new HashTable<>(2);

        hashTable.insert("Djordjije", 27);
        hashTable.put("Bogdan", 30);
        hashTable.add("Vesna", 27);
        hashTable.add("Petar", 27);
        hashTable.insert("Marko", 27);

        List<String> keys    = hashTable.keys();
        List<Integer> values = hashTable.values();

        for(String key : hashTable)
            Assertions.assertEquals(values.get(keys.indexOf(key)), hashTable.get(key));
    }
}
