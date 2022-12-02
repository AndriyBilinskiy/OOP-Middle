import com.midterm.demo.strategies.PDLParsingStrategy;
import com.midterm.demo.strategies.Strategy;

public class PDLTest {
    public static void main(String[] args) {
        Strategy strategy = new PDLParsingStrategy();
        System.out.println(strategy.getData("www.mcdonalds.com"));
    }
}
