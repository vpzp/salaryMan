package com.example.demo.Salary;

import com.example.demo.Company.Company;
import com.example.demo.SiteUser.SiteUser;
import com.example.demo.SiteUser.SiteUserService;
import com.example.demo.SiteUser.UserCreateForm;
import com.example.demo.Staff.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SiteUserService siteUserService;
    public final SalaryService salaryService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/management")
    public String getManagement(Model model, Principal principal, @RequestParam(value = "page", defaultValue = "0") int page){
        Company company = siteUserService.getUserByName(principal.getName()).getCompany();
        Page<SiteUser> paging = siteUserService.getList(company, page);
        model.addAttribute("paging", paging);
        model.addAttribute("salaryService", salaryService);

        return "management_form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specification")
    public String specification(Principal principal){
        SiteUser siteUser = siteUserService.getUserByName(principal.getName());
        if (siteUser.getAuthority().equals("관리자")){
            return "redirect:/salary/specification/list";
        }else {
            return "redirect:/salary/specification/user";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/specification/user")
    public String specificationUser(Model model, Principal principal){
        SiteUser siteUser = siteUserService.getUserByName(principal.getName());
        model.addAttribute("salaryService", salaryService);
        model.addAttribute("user", siteUser);

        return "specification_form";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/specification/list")
    public String specificationAdmin(Model model, Principal principal, @RequestParam(value = "page", defaultValue = "0") int page){
        Company company = siteUserService.getUserByName(principal.getName()).getCompany();
        Page<SiteUser> paging = siteUserService.getList(company, page);
        model.addAttribute("paging", paging);
        model.addAttribute("salaryService", salaryService);

        return "specification_list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/specification/list/{id}")
    public String getSpecification(Model model, @PathVariable("id") long longId){
        SiteUser siteUser = siteUserService.getUserById(longId);
        model.addAttribute("salaryService", salaryService);
        model.addAttribute("user", siteUser);

        return "specification_form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/option/{id}")
    public String test3(Model model, SalaryOptionForm salaryOptionForm , @PathVariable("id") long longId){
        SiteUser user = siteUserService.getUserById(longId);
        model.addAttribute("user", user);

        return "option_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/option/{id}")
    public String optionCreate(Model model, @Valid SalaryOptionForm salaryOptionForm, BindingResult bindingResult , @PathVariable("id") long longId){
        if(bindingResult.hasErrors()){
            return "option_form";
        }try {
            SiteUser user = siteUserService.getUserById(longId);
            model.addAttribute("user", user);
            siteUserService.setOption(user.getLongId(), salaryOptionForm.getPrice(), salaryOptionForm.getNightTime(), salaryOptionForm.getHolidayTime(),
                    salaryOptionForm.getOverTime(), salaryOptionForm.getRank(), salaryOptionForm.getDepartment());

        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "option_form";
        }

        return "redirect:/main";
    }

}
