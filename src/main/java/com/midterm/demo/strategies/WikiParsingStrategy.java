package com.midterm.demo.strategies;

import com.midterm.demo.company.CompanyInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WikiParsingStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link) {
        CompanyInfo companyInfo = new CompanyInfo();
        try {
            String googleQuery = "https://www.google.com/search?q=site:en.wikipedia.org " + link;
            Document googleSearchPage = Jsoup.connect(googleQuery).get();
            String wikiUrl = googleSearchPage.select("div.yuRUbf").select("a").attr("href");
            Document document = Jsoup.connect(wikiUrl).get();
            String name = document.select("h1").text();
            companyInfo.setName(name);

            Element info = document.select("table.infobox").first();
            if (info != null) {
                Element employees = info.select("th:contains(employees)").first();
                if (employees != null) {
                    Element employeesNum = employees.nextElementSibling();
                    if (employeesNum != null) {
                        companyInfo.setEmployees(employeesNum.text());
                    }
                }
                Element address = info.select("th:contains(Headquarters)").first();
                if (address != null) {
                    Element addressStreet = address.nextElementSibling();
                    if (addressStreet != null) {
                        companyInfo.setAddress(addressStreet.text());
                    }
                }
                Element logo = info.select("th:contains(image)").first();
                if (logo != null) {
                    Element logoLink = logo.nextElementSibling();
                    if (logoLink != null) {
                        companyInfo.setLogo(logoLink.text());
                    }
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companyInfo;
    }
}
