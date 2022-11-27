import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DomainParser implements Parser {
    @Override
    public Response parse(String link) throws IOException {
        Response response = new Response();
        Document doc = Jsoup.connect(link ).get();
        Elements el = doc.head().select("meta").select("[property = og:site_name]");
        response.setName(el.first().attr("content"));
        return response;
    }
}
