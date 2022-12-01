import com.midterm.demo.strategies.WikiParsingStrategy;

public class TestWiki {
    public static void main(String[] args) {
        WikiParsingStrategy wikiParsingStrategy = new WikiParsingStrategy();
        System.out.println(wikiParsingStrategy.getData("ucu.edu.ua"));
    }
}

