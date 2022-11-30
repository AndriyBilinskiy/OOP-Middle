package demo;

import demo.Strategies.BrandFetchStrategy;
import demo.Strategies.DomainParsingStrategy;
import demo.Strategies.Strategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StrategiesMerger {
    List <Strategy> strategies = List.of(new BrandFetchStrategy(), new DomainParsingStrategy());
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
