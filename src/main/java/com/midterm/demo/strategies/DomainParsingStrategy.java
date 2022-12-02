package com.midterm.demo.strategies;

import java.net.URI;
import com.midterm.demo.CompanyInfo;
import com.midterm.demo.Strategy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DomainParsingStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link){
        try {
            CompanyInfo response = new CompanyInfo();
            Document doc = Jsoup.connect(link).get();
            Elements el = doc.head().select("meta").select("[property = og:site_name]");
//            URI uri = new URI(link);
//            String host = uri.getHost();
//            response.setDomain(host);
            response.setName(el.first().attr("content"));
            return response;
        } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
