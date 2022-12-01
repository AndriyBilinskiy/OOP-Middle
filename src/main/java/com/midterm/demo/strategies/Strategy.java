package com.midterm.demo.strategies;

import com.midterm.demo.company.CompanyInfo;

public interface Strategy {
    public CompanyInfo getData(String link);
}
