package com.example.demo.SiteUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 15)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String id;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @Column(columnDefinition =  "TEXT")
    private String company;

    @NotEmpty(message = "이름은 필수항목입니다.")
    private String name;

    private String phoneNumber;

    private String rank;

    private String department;
    @Email
    private String email;

    private String bank;

    private String accountNumber;
}
