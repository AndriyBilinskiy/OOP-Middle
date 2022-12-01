package com.midterm.demo;

import com.midterm.demo.company.CompanyInfo;
import com.midterm.demo.strategies.BrandFetchStrategy;
import com.midterm.demo.strategies.GoogleSearchStrategy;
import com.midterm.demo.strategies.Strategy;
import com.midterm.demo.strategies.WikiParsingStrategy;


import java.util.List;

public class StrategiesMerger {
    List <Strategy> strategies = List.of(new BrandFetchStrategy(), new GoogleSearchStrategy(), new WikiParsingStrategy());
    public CompanyInfo getData(String link) {
        CompanyInfo result = new CompanyInfo();
        for (int i = 0; i < strategies.toArray().length; i++) {
            CompanyInfo curRes = strategies.get(i).getData(link);
            if (result.getAddress() == null) {
                result.setAddress(curRes.getAddress());
            }if (result.getEmployees() == null) {
                result.setEmployees(curRes.getEmployees());
            }if (result.getFacebook() == null) {
                result.setFacebook(curRes.getFacebook());
            }if (result.getTwitter() == null) {
                result.setTwitter(curRes.getTwitter());
            }if (result.getIcon() == null) {
                result.setIcon(curRes.getIcon());
            }if (result.getLogo() == null) {
                result.setLogo(curRes.getLogo());
            }if (result.getName() == null) {
                result.setName(curRes.getName());
            }
        }
        return result;
    }

}