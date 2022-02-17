package collections;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class SetInterface {

    public static void main(String[] args) {

        // initial set
        Set<Product> initialSet = Set.of(
            new Product("Table", 100),
            new Product("TV", 450),
            new Product("Chair", 250)
        );

        // HashSet implements Set (not ordered)
        HashSet<Product> hashSet = new HashSet<>(7); // initial capacity

        // inserting elements
        hashSet.add(new Product("Computer", 820));
        hashSet.addAll(initialSet);

        System.out.println("HashSet (1): " + hashSet);

        // searching elements
        Product exists = new Product("Table", 100);
        Product doesNotExist = new Product("Car", 15250);
        assert(hashSet.contains(exists));
        assert(!hashSet.contains(doesNotExist));
        assert(hashSet.containsAll(initialSet));

        // removing elements
        hashSet.remove(exists);
        System.out.println("HashSet (2): " + hashSet);

        // traversing set elements
        hashSet.forEach(product -> System.out.print(product + " "));
        System.out.println();
        for (Product product : hashSet) {
            System.out.print(product + " ");
        }
        System.out.println();

        // LinkedHashSet implements Set (maintains insertion order)
        LinkedHashSet<Product> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(new Product("Computer", 820));
        linkedHashSet.addAll(initialSet);

        System.out.println("LinkedHashSet (1): " + linkedHashSet);

        // TreeSet implements NavigableSet implements SortedSet implements Set (maintains elements in sorted order)
        TreeSet<Product> treeSet = new TreeSet<>();

        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(initialSet);

        System.out.println("TreeSet (1): " + treeSet);
        assert(treeSet.first().equals(new Product("Chair", 250)));
        assert(treeSet.last().equals(new Product("Table", 100)));

        // COMPARATOR interface COMPARATOR != COMPARABLE
        Comparator<Product> comparatorFirst = (first, second) -> first.getPrice().compareTo(second.getPrice());
        Comparator<Product> comparatorSecond = (first, second) -> first.getName().compareTo(second.getName());

        treeSet = new TreeSet<>(comparatorFirst);
        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(initialSet);
        System.out.println("TreeSet (2): " + treeSet);

        treeSet = new TreeSet<>(comparatorSecond);
        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(initialSet);
        System.out.println("TreeSet (3): " + treeSet);
    }

}
