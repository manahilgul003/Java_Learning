import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Creating a queue
        Queue<String> queue = new LinkedList<>();

        // Adding elements
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        // Accessing elements
        System.out.println("Head of the queue: " + queue.peek());

        // Removing elements
        while (!queue.isEmpty()) {
            System.out.println("Processing: " + queue.poll());
        }
    }
}
