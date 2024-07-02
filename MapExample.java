import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Creating a map
        Map<String, Integer> fruitPrices = new HashMap<>();

        // Adding key-value pairs
        fruitPrices.put("Apple", 3);
        fruitPrices.put("Banana", 2);
        fruitPrices.put("Cherry", 5);

        // Accessing values
        System.out.println("Price of Apple: " + fruitPrices.get("Apple"));

        // Iterating over the map
        for (Map.Entry<String, Integer> entry : fruitPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Removing a key-value pair
        fruitPrices.remove("Banana");
        System.out.println("After removal: " + fruitPrices);
    }
}
