package com.example.demo.SiteUser;

import com.example.demo.Company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long longId;

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

    @ColumnDefault("'사용자'")
    private String authority;

    @ColumnDefault("false")
    private boolean isSpouse;

    @ColumnDefault("0")
    private int children;

    private int price;

    private int timePrice;

    @ColumnDefault("0")
    private int overTime;

    @ColumnDefault("0")
    private int nightTime;

    @ColumnDefault("0")
    private int holidayTime;

}
