package com.ll.jsb.domain.user.user.repository;

import com.ll.jsb.domain.user.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
