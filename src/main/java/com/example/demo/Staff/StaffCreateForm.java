package com.example.demo.Staff;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class StaffCreateForm {
    @Size(min = 3, max = 15)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    String id;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @Size(min = 3, max = 10)
    @NotEmpty(message = "별명은 필수항목입니다.")
    String name;

    String rank;

    String department;

    String bank;

    String bankNumber;

    String phoneNumber;
}
