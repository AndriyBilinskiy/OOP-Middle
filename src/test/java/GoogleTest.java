import com.midterm.demo.strategies.BrandFetchStrategy;
import com.midterm.demo.strategies.GoogleSearchStrategy;
import com.midterm.demo.strategies.WikiParsingStrategy;

public class GoogleTest {
    public static void main(String[] args) {
        GoogleSearchStrategy wikiParsingStrategy = new GoogleSearchStrategy();
        System.out.println(wikiParsingStrategy.getData("ucu.edu.ua"));
    }
}
