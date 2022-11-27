import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class TestParser {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://bolt.eu/" ).get();
        Element head = doc.head();
        Elements el = head.select("meta").select("[property = og:site_name]");
        System.out.println(el.first().attr("content"));
    }
}
