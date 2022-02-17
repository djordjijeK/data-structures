package collections;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapInterface {

    public static void main(String[] args) {

        Map<String, Product> initialMap = Map.of(
        "Table", new Product("Table", 100),
        "TV", new Product("TV", 450),
        "Chair", new Product("Chair", 250)
        );

        // HashMap implements Map (not ordered)
        HashMap<String, Product> hashMap = new HashMap<>();

        // inserting elements
        hashMap.put("Computer", new Product("Computer", 820));
        hashMap.putAll(initialMap);

        System.out.println("HashMap (1): " + hashMap);

        // searching elements
        assert(!hashMap.containsKey("Door"));
        assert(hashMap.containsKey("Computer"));
        assert(hashMap.getOrDefault("NotExistKey", null) == null);

        // updating elements
        hashMap.put("Computer", new Product("Computer", 875));
        assert(hashMap.get("Computer").equals(new Product("Computer", 875)));

        // deleting elements
        hashMap.remove("Chair");
        assert(hashMap.get("Chair") == null);

        System.out.println("HashMap (2): " + hashMap);

        // traversing map
        for(Map.Entry<String, Product> entry : hashMap.entrySet()) {
            System.out.print("Key: " + entry.getKey() + ", Valie: " + entry.getValue() + " | ");
        }
        System.out.println();
        hashMap.forEach((key, value) -> System.out.print("Key: " + key + ", Value: " + value + " | "));
        System.out.println();
        for(String key : hashMap.keySet()) {
            System.out.print("Key: " + key + ", Valie: " + hashMap.get(key) + " | ");
        }
        System.out.println();

        // LinkedHashMap implements Map (order of insertion preserved)
        LinkedHashMap<String, Product> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("Computer", new Product("Computer", 820));
        linkedHashMap.put("Table", new Product("Table", 100));
        linkedHashMap.put("TV", new Product("TV", 450));

        System.out.println("LinkedHashMap (1): " + linkedHashMap);

        // TreeMap implements Map (elements sorted)
        TreeMap<String, Product> treeMap = new TreeMap<>();

        treeMap.put("Computer", new Product("Computer", 820));
        treeMap.putAll(initialMap);

        System.out.println("TreeMap (1): " + treeMap);
    }

}
