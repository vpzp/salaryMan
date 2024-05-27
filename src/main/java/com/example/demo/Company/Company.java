package com.example.demo.Company;

import com.example.demo.SiteUser.SiteUser;
import com.example.demo.Staff.Staff;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany()
    private List<SiteUser> siteUser;

    @OneToMany()
    private List<Staff> staff;

}
