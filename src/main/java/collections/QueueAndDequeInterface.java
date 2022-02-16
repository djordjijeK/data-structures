package collections;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QueueAndDequeInterface {

    public static void main(String[] args) {

        Queue<Product> queue = new LinkedList<>();

        // add element to the queue
        queue.add(new Product("Table", 100));
        queue.offer(new Product("TV", 450));
        queue.offer(new Product("Computer", 820));

        System.out.println("Queue (1): " + queue);

        // remove element from the queue
        System.out.println("Polling: " + queue.poll());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Queue (2): " + queue);

        // Deque (as Stack) implements Queue implements Collection
        ArrayDeque<Product> stack = new ArrayDeque<>();
        stack.push(new Product("Table", 100));
        stack.push(new Product("TV", 450));

        System.out.println("Deque as stack (1): " + stack);

        // Deque (as Queue) implements Queue implements Collection
        ArrayDeque<Product> dequeQueue = new ArrayDeque<>();
        dequeQueue.offer(new Product("Table", 100));
        dequeQueue.offer(new Product("TV", 450));

        System.out.println("Deque as queue (1): " + dequeQueue);

        // PriorityQueue
        PriorityQueue<Product> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Product("TV", 450));
        priorityQueue.offer(new Product("Table", 100));
        priorityQueue.offer(new Product("Chair", 250));

        System.out.println("PriorityQueue (1): " + priorityQueue);
    }

}
