package demo.Strategies;

import demo.CompanyInfo;

import java.io.IOException;

public interface Strategy {
    public CompanyInfo getData(String link);
}
