package com.midterm.demo;

import com.midterm.demo.company.CompanyInfo;
import com.midterm.demo.strategies.BrandFetchStrategy;
import com.midterm.demo.strategies.GoogleSearchStrategy;
import com.midterm.demo.strategies.Strategy;
import com.midterm.demo.strategies.WikiParsingStrategy;


import java.util.List;

public class StrategiesMerger {
    List <Strategy> strategies = List.of(new BrandFetchStrategy(), new GoogleSearchStrategy(),
            new WikiParsingStrategy());
    public CompanyInfo getData(String link) {
        CompanyInfo result = new CompanyInfo();
        result.setLink(link);
        MostFrequent name = new MostFrequent(), facebook = new MostFrequent(), twitter = new MostFrequent(),
                logo = new MostFrequent(), icon = new MostFrequent(), address = new MostFrequent(),
                employees = new MostFrequent();
        for (int i = 0; i < strategies.toArray().length; i++) {
            CompanyInfo curRes = strategies.get(i).getData(link);
            name.add(curRes.getName());
            facebook.add(curRes.getFacebook());
            twitter.add(curRes.getTwitter());
            logo.add(curRes.getLogo());
            icon.add(curRes.getIcon());
            address.add(curRes.getAddress());
            employees.add(curRes.getEmployees());
        }
        result.setName(name.getMostFrequent());
        result.setFacebook(facebook.getMostFrequent());
        result.setTwitter(twitter.getMostFrequent());
        result.setLogo(logo.getMostFrequent());
        result.setIcon(icon.getMostFrequent());
        result.setAddress(address.getMostFrequent());
        result.setEmployees(employees.getMostFrequent());
        return result;
    }

}