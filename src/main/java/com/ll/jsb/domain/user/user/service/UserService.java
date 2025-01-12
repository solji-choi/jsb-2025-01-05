package com.ll.jsb.domain.user.user.service;

import com.ll.jsb.domain.user.user.entity.SiteUser;
import com.ll.jsb.domain.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser signup(String username, String password, String email) {
        SiteUser user = SiteUser
                .builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .build();

        return userRepository.save(user);
    }
}
