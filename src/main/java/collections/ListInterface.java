package collections;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListInterface {

    public static void main(String[] args) {

        // initial list
        List<Integer> initialList = Arrays.asList(7, 5, 6);

        // ArrayList implements List
        ArrayList<Integer> arrayList = new ArrayList<>(10); // initial capacity

        // inserting elements
        arrayList.add(1);
        arrayList.addAll(initialList);
        arrayList.add(1, 2);

        System.out.println("ArrayList (1): " + arrayList);

        // updating elements
        arrayList.set(0, 10);
        assert(arrayList.get(0) == 10);

        // searching elements
        assert(arrayList.indexOf(5) == 3);
        assert(!arrayList.contains(100));

        // deleting elements
        arrayList.remove((Integer) 5);
        arrayList.remove(0);

        System.out.println("ArrayList (2): " + arrayList);

        // traversing list elements
        arrayList.forEach(number -> System.out.print(number + " | "));
        System.out.println();
        for (Integer number : arrayList) {
            System.out.print(number + " | ");
        }
        System.out.println();
        for (int index = 0; index < arrayList.size(); index++) {
            System.out.print(arrayList.get(index) + " | ");
        }
        System.out.println();

        // LinkedList implements List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("First");
        linkedList.add("Second");
        linkedList.addLast("Last");

        System.out.println("Linked List (1): " + linkedList);

        assert(linkedList.removeFirst().equals("First"));
        assert(linkedList.removeLast().equals("Last"));

        linkedList.set(0, "Updated Second");
        System.out.println("Linked List (2): " + linkedList);

        // Stack implements List
        Stack<String> stack = new Stack<>();
        stack.push("Third");
        stack.push("Second");
        stack.push("First");

        System.out.println("Stack (1): " + stack);

        stack.pop();
        assert(stack.peek().equals("Second"));
        stack.pop();

        System.out.println("Stack (2): " + stack);
    }

}
