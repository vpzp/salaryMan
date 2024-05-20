package com.example.demo.Company;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;

    public void Create(String name){
        Company company = new Company();
        company.setName(name);

        this.companyRepository.save(company);
    }

    public Company getCompanyByName(String name){
        Optional<Company> company = this.companyRepository.findByName(name);
        if (company.isPresent()){
            return company.get();
        }else {
            throw new NoSuchElementException("companyFindByName 값이 없습니다.");
        }
    }
}
