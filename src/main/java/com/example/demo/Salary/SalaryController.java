package com.example.demo.Salary;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyService;
import com.example.demo.SiteUser.SiteUser;
import com.example.demo.SiteUser.SiteUserService;
import com.example.demo.Staff.Staff;
import com.example.demo.Staff.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final StaffService staffService;
    private final SiteUserService siteUserService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/management")
    public String test(Model model, Principal principal, @RequestParam(value = "page", defaultValue = "0") int page){
        Company company = siteUserService.getUserByName(principal.getName()).getCompany();
        List<Staff> staffList = staffService.getStaffFindById(company);
        Page<Staff> paging = staffService.getList(company, page);
        model.addAttribute("staffList", staffList);
        model.addAttribute("paging", paging);
        return "management_form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specification")
    public String test2(){
        return "specification_form";
    }

}
