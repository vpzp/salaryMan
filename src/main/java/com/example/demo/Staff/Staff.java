package com.example.demo.Staff;

import com.example.demo.Company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rank;

    private String department;

    private String bank;

    private String accountNumber;

    private String phoneNumber;

    @ManyToOne
    private Company company;

//    private int time;
//
//    private int overTime;
//
//    private int textPercent;
//
//    private int price;
}
