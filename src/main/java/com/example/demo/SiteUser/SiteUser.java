package com.example.demo.SiteUser;

import com.example.demo.Company.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    private String id;

    private String password;

    @ManyToOne
    private Company company;

    @Column(columnDefinition = "TEXT", length = 10)
    private String name;

    private String phoneNumber;

    private String rank;

    private String department;

    private String email;

    private String bank;

    private String accountNumber;

}
