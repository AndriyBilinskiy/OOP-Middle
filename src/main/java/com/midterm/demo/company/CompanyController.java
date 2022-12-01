package com.midterm.demo.company;

import com.midterm.demo.StrategiesMerger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping

public class CompanyController {

    private final CompanyService companyService;
    private final StrategiesMerger strategiesMerger;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
        this.strategiesMerger = new StrategiesMerger();
    }

    @GetMapping(path = "companies")
    public Optional<CompanyInfo> getCompanyInfo(String link) {
        if (companyService.getCompanyInfo(link).isEmpty()) {
            CompanyInfo res = strategiesMerger.getData(link);
            companyService.addCompanyInfo(res);
            return Optional.ofNullable(res);
        }else {
            return companyService.getCompanyInfo(link);
        }

    }
    @PostMapping
    public void addCompanyInfo(CompanyInfo companyInfo) {
        companyService.addCompanyInfo(companyInfo);
    }
}
