import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

public class LinkedListExample {
    public static void main(String[] args) {
        // Using LinkedList as a List
        List<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("List: " + list);

        // Accessing elements
        System.out.println("First element: " + list.get(0));
        
        // Removing elements
        list.remove("Banana");
        System.out.println("After removal: " + list);

        // Using LinkedList as a Queue/Deque
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.addLast("Cherry");
        System.out.println("Deque: " + deque);

        // Accessing elements
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());

        // Removing elements from both ends
        deque.removeFirst();
        deque.removeLast();
        System.out.println("After removals: " + deque);
    }
}
