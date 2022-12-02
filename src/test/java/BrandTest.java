import com.midterm.demo.strategies.BrandFetchStrategy;
import com.midterm.demo.strategies.WikiParsingStrategy;

public class BrandTest {
    public static void main(String[] args) {
        BrandFetchStrategy wikiParsingStrategy = new BrandFetchStrategy();
        System.out.println(wikiParsingStrategy.getData("mcdonalds.com"));
    }
}
