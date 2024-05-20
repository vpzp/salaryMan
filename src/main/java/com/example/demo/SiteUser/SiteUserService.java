package com.example.demo.SiteUser;

import com.example.demo.Company.CompanyService;
import com.example.demo.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String id, String password, String company, String name,
                           String phoneNumber, String rank, String department, String email, String bank, String accountNumber) {
        SiteUser siteUser = new SiteUser();
        siteUser.setId(id);
        siteUser.setPassword(passwordEncoder.encode(password));
        siteUser.setCompany(companyService.getCompanyByName(company));
        siteUser.setName(name);
        siteUser.setPhoneNumber(phoneNumber);
        siteUser.setRank(rank);
        siteUser.setDepartment(department);
        siteUser.setEmail(email);
        siteUser.setBank(bank);
        siteUser.setAccountNumber(accountNumber);
        this.siteUserRepository.save(siteUser);
        return siteUser;
    }

    public SiteUser getUserByName(String name){
        Optional<SiteUser> siteUser = this.siteUserRepository.findByName(name);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteUser객체가 없습니다");
        }
    }
}
