package collections;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class SetInterface {

    public static void main(String[] args) {

        // temporary set
        Set<Product> temporarySet = Set.of(
            new Product("Table", 100),
            new Product("TV", 450),
            new Product("Chair", 250)
        );

        // HashSet implements Set
        // HashSet is not ordered
        HashSet<Product> hashSet = new HashSet<>(7); // initial capacity

        // inserting elements
        hashSet.add(new Product("Computer", 820));
        hashSet.addAll(temporarySet);

        System.out.println("HashSet (1): " + hashSet);

        // searching elements
        Product exists = new Product("Table", 100);
        Product doesNotExist = new Product("Car", 15250);
        hashSet.contains(exists);             // true
        hashSet.contains(doesNotExist);       // false
        hashSet.containsAll(temporarySet);    // true

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

        // LinkedHashSet implements Set
        // LinkedHashSet maintains insertion order
        LinkedHashSet<Product> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(new Product("Computer", 820));
        linkedHashSet.addAll(temporarySet);

        System.out.println("LinkedHashSet (1): " + linkedHashSet);

        // TreeSet implements NavigableSet implements SortedSet implements Set
        // TreeSet maintains elements in sorted order
        TreeSet<Product> treeSet = new TreeSet<>();

        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(temporarySet);

        System.out.println("TreeSet (1): " + treeSet);
        System.out.println("First: " + treeSet.first());
        System.out.println("Last: " + treeSet.last());

        // COMPARATOR interface COMPARATOR != COMPARABLE
        Comparator<Product> comparatorFirst = (first, second) -> first.getAge().compareTo(second.getAge());
        Comparator<Product> comparatorSecond = (first, second) -> first.getName().compareTo(second.getName());

        treeSet = new TreeSet<>(comparatorFirst);
        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(temporarySet);
        System.out.println("TreeSet (2): " + treeSet);

        treeSet = new TreeSet<>(comparatorSecond);
        treeSet.add(new Product("Computer", 820));
        treeSet.addAll(temporarySet);
        System.out.println("TreeSet (3): " + treeSet);
    }

}
