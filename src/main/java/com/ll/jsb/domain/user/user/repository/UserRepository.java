package com.ll.jsb.domain.user.user.repository;

import com.ll.jsb.domain.user.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByUsername(String username);
}
