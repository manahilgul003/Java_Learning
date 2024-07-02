import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Creating a set
        Set<String> fruits = new HashSet<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple"); // Duplicate element

        // Iterating over the set
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Removing an element
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
    }
}
