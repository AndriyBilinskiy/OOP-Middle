package com.midterm.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CompanyRepository extends JpaRepository<CompanyInfo, Integer> {
    public Optional<CompanyInfo> findCompanyInfoByName(String name);
}
