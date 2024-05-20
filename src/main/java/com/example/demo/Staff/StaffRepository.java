package com.example.demo.Staff;

import com.example.demo.Company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff , String> {
    List<Staff> findByCompany(Company company);

    Page<Staff> findByCompany(Company company, Pageable pageable);

    @Query(value = "SELECT s FROM Staff s WHERE s.company = :company ORDER BY " +
            "FIELD(s.rank, '사장', '전무', '이사', '과장', '대리', '사원', '인턴')")
    Page<Staff> findByCompanyOrderByRank(Company company, Pageable pageable);
}
