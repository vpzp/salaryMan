package com.example.demo.SiteUser;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModifyForm {
    private String name;

    private String phoneNumber;

    @Email
    private String email;

    private String company;

    private String bank;

    private String accountNumber;
}
