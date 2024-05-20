package com.example.demo.SiteUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, String> {
    Optional<SiteUser> findById(String Id);

    Optional<SiteUser> findByName(String id);
}
