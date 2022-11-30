package com.midterm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;
    public Optional<CompanyInfo> getCompanyInfo(String name) {
        return companyRepository.findCompanyInfoByName(name);
    }
    public void addCompanyInfo(CompanyInfo companyInfo){
        companyRepository.save(companyInfo);
    }

}
