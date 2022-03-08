package com.backend.study.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String id;
    @Length(min = 1, max = 25)
    private String name;
    @Length(min = 1, max = 45)
    private String password;
    @NotNull
    private UserRole role;
    private UserStatus status;
    private String useYn;
    private String creatorId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
