package com.midterm.demo.strategies;


import com.midterm.demo.company.CompanyInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.UnknownHostException;

public class DomainParsingStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link){
        CompanyInfo response = new CompanyInfo();
        try {
            Document doc = Jsoup.connect("https://" + link).get();
            Elements el = doc.head().select("meta").select("[property = og:site_name]");
            if (el.first() != null) {
                response.setName(el.first().attr("content"));
            }
        } catch (IOException ignored) {}
        return response;

    }
}
