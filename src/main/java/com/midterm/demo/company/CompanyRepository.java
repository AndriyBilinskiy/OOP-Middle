package com.midterm.demo.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CompanyRepository extends JpaRepository<CompanyInfo, Integer> {
    Optional<CompanyInfo> findCompanyInfoByLink(String link);
}
