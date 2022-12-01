import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<String> elements = List.of("A","d","A");
        Map<String, Long> temp = elements.stream()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()));


        System.out.println( new HashSet<>(temp.values()).size() < temp.size() ?
                null : temp.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get()
        );

    }
}
