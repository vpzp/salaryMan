package com.example.demo.SiteUser;

import com.example.demo.Company.Company;
import com.example.demo.Staff.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findById(String Id);

    Optional<SiteUser> findByLongId(long id);

    Optional<SiteUser> findByName(String name);

    List<SiteUser> findByCompany(Company company);

    @Query(value = "SELECT s FROM SiteUser s WHERE s.company = :company ORDER BY " +
            "FIELD(s.rank, '사장', '전무', '이사', '과장', '대리', '사원', '인턴')")
    Page<SiteUser> findByCompanyOrderByRank(Company company, Pageable pageable);
}
