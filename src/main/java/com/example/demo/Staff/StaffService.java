package com.example.demo.Staff;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyService;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StaffService {
    private final StaffRepository staffRepository;
    private final CompanyService companyService;

    public void create(String name, String rank, String department, String bank, String accountNumber,
                       String phoneNumber, String companyName){
        Staff staff = new Staff();
        staff.setName(name);
        staff.setRank(rank);
        staff.setDepartment(department);
        staff.setBank(bank);
        staff.setAccountNumber(accountNumber);
        staff.setPhoneNumber(phoneNumber);
        staff.setCompany(companyService.getCompanyByName(companyName));

        this.staffRepository.save(staff);
    }

    public Page<Staff> getList(Company company, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return staffRepository.findByCompanyOrderByRank(company, pageable);
    }

    public List<Staff> getStaffFindById(Company company){
        return this.staffRepository.findByCompany(company);
    }
}
