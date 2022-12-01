package com.midterm.demo.company;

import com.midterm.demo.StrategiesMerger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        boolean notExists = companyService.getCompanyInfo(link).isEmpty();
        if (notExists) {
            CompanyInfo res = strategiesMerger.getData(link);
            companyService.addCompanyInfo(res);
            return Optional.ofNullable(res);
        }else {
            return companyService.getCompanyInfo(link);
        }

    }
    @PostMapping(path = "companies/edit")
    public void addCompanyInfo(@RequestBody CompanyInfo companyInfo) {
        boolean notExists = companyService.getCompanyInfo(companyInfo.getLink()).isEmpty();
        if(notExists) {
            companyService.addCompanyInfo(companyInfo);
        }
    }
}
