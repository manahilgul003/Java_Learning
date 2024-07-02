import java.util.*;
import java.util.stream.*;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry", "Date");

        // Filtering and Mapping
        List<String> filteredList = list.stream()
                                        .filter(s -> s.startsWith("A"))
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toList());
        System.out.println("Filtered List: " + filteredList);

        // Reducing
        Optional<String> concatenated = list.stream()
                                            .reduce((s1, s2) -> s1 + ", " + s2);
        concatenated.ifPresent(System.out::println);

        // Parallel Stream
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.parallelStream()
                         .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}
