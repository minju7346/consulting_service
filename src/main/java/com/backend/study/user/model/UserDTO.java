package com.backend.study.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;

@Getter
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String password;
    private UserRole role;
    private UserStatus status;
    private String useYn;
    private String creatorId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
