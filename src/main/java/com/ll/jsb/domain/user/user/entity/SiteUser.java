package com.ll.jsb.domain.user.user.entity;

import com.ll.jsb.global.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUser extends BaseTime {
    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;
}
