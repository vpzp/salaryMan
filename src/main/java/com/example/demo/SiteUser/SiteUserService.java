package com.example.demo.SiteUser;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyService;
import com.example.demo.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String id, String password, String company, String name,
                           String phoneNumber, String rank, String department, String email, String bank, String accountNumber,
                           String authority, boolean spouse, int children) {
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
        siteUser.setAuthority(authority);
        siteUser.setSpouse(spouse);
        siteUser.setChildren(children);
        switch (rank){
            case "사장" : siteUser.setPrice(8000000);
                break;
            case "전무" :siteUser.setPrice(7000000);
                break;
            case "이사" :siteUser.setPrice(6000000);
                break;
            case "과장" :siteUser.setPrice(5000000);
                break;
            case "대리" :siteUser.setPrice(4000000);
                break;
            case "사원" :siteUser.setPrice(3000000);
                break;
            case "인턴" :siteUser.setPrice(2000000);
                break;
        }
        siteUser.setTimePrice(siteUser.getPrice() / 209);
        this.siteUserRepository.save(siteUser);
        return siteUser;
    }

    public SiteUser setOption(long longId, int price, int nightTime, int holidayTime, int overTime, String rank, String department){
        SiteUser siteUser = getUserById(longId);
        siteUser.setPrice(price);
        siteUser.setNightTime(nightTime);
        siteUser.setHolidayTime(holidayTime);
        siteUser.setOverTime(overTime);
        siteUser.setRank(rank);
        siteUser.setDepartment(department);
        siteUserRepository.save(siteUser);

        return siteUser;
    }

    public SiteUser modify(long longId, String phoneNumber, String email, String company, String bank, String accountNumber){
        SiteUser siteUser = getUserById(longId);
        siteUser.setPhoneNumber(phoneNumber);
        siteUser.setEmail(email);
        siteUser.setCompany(companyService.getCompanyByName(company));
        siteUser.setBank(bank);
        siteUser.setAccountNumber(accountNumber);
        siteUserRepository.save(siteUser);

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

    public SiteUser getUserById(long longId){
        Optional<SiteUser> siteUser = this.siteUserRepository.findByLongId(longId);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteUser객체가 없습니다");
        }
    }

    public Page<SiteUser> getList(Company company, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return siteUserRepository.findByCompanyOrderByRank(company, pageable);
    }

    public List<SiteUser> getSiteUserFindByCompany(Company company){
        return this.siteUserRepository.findByCompany(company);
    }
}
