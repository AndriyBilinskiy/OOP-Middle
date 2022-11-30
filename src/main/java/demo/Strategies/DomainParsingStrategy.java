package demo.Strategies;

import demo.CompanyInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DomainParsingStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link) throws IOException {
        CompanyInfo response = new CompanyInfo();
        Document doc = Jsoup.connect(link ).get();
        Elements el = doc.head().select("meta").select("[property = og:site_name]");
        response.setName(el.first().attr("content"));
        return response;
    }
}
