package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "user")

public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public Optional<CompanyInfo> getCompanyInfo(String name) {
        //TODO
        return companyService.getCompanyInfo(name);
    }
    @PostMapping
    public void addCompanyInfo(CompanyInfo companyInfo) {
        companyService.addCompanyInfo(companyInfo);
    }
}
