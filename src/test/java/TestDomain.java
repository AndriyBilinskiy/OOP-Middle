import com.midterm.demo.strategies.DomainParsingStrategy;
import com.midterm.demo.strategies.Strategy;

public class TestDomain {
    public static void main(String[] args) {
        Strategy strategy = new DomainParsingStrategy();
        System.out.println(strategy.getData("www.mcdonalds"));
    }
}
