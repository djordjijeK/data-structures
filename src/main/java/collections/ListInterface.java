package collections;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListInterface {

    public static void main(String[] args) {

        // temporary list
        List<Integer> temporaryList = Arrays.asList(7, 5, 6);

        // ArrayList implements List
        ArrayList<Integer> arrayList = new ArrayList<>(10); // initial capacity

        // inserting elements
        arrayList.add(1);                       // [1]
        arrayList.addAll(temporaryList);        // [1, 7, 5, 6]
        arrayList.add(1, 2);      // [1, 2, 7, 5, 6] - element shifting

        // updating elements
        arrayList.set(0, 10);                   // [10, 2, 7, 5, 6]

        // searching elements
        Integer x = arrayList.get(3);           // 5
        arrayList.indexOf(5);                   // 3
        arrayList.contains(100);                // false

        // deleting elements
        arrayList.remove((Integer) 5);          // [10, 2, 7, 6]
        arrayList.remove(0);              // [2, 7, 6]

        // traversing list elements
        arrayList.forEach(number -> System.out.print(number + " "));
        System.out.println();
        for (Integer number : arrayList) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int index = 0; index < arrayList.size(); index++) {
            System.out.print(arrayList.get(index) + " ");
        }
        System.out.println();

        // LinkedList implements List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("First");
        linkedList.add("Second");
        linkedList.addLast("Last");

        System.out.println("Linked List: " + linkedList);  // ["First", "Second", "Third"]

        linkedList.removeFirst();                          // ["Second", "Last"]
        linkedList.removeLast();                           // ["Second"]

        linkedList.set(0, "Updated Second");
        System.out.println("Linked List: " + linkedList);  // ["Updated Second"]

        // Stack implements List
        Stack<String> stack = new Stack<>();
        stack.push("Third");
        stack.push("Second");
        stack.push("First");

        System.out.println("Stack: " + stack);              // ["Third", "Second", "First"]

        stack.pop();                                        // ["Second", "Third"]
        System.out.println("Peeking: " + stack.peek());
        stack.pop();
        System.out.println(stack);                          // ["Third"]
    }

}
