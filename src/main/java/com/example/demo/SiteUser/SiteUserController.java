package com.example.demo.SiteUser;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class SiteUserController {
    private final SiteUserService siteUserService;
    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String login(){
        return "login_form";
    }

    @GetMapping("/signup")
    public String choice(UserCreateForm userCreateForm){
        return "signup_form";
    }

    @PostMapping("/signup")
    public String create(@Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "signup_form";
        }
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2", "passwordIncorrect",
                    "2개의 메시지가 일치하지 않습니다.");
            return "signup_form";
        }
        try{
            siteUserService.create(userCreateForm.getId(), userCreateForm.getPassword1(), userCreateForm.getCompany(),
                    userCreateForm.getName(), userCreateForm.getPhoneNumber(), userCreateForm.getRank(), userCreateForm.getDepartment(),
                    userCreateForm.getEmail(),userCreateForm.getBank(), userCreateForm.getAccountNumber());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }
        return "redirect:/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage(Principal principal, Model model){
        Company company = siteUserService.getUserByName(principal.getName()).getCompany();
        model.addAttribute("company", company);
        model.addAttribute("siteUser", siteUserService.getUserByName(principal.getName()));
        return "mypage_form";
    }
}
