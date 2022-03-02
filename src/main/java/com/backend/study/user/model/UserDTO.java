package com.backend.study.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;

@Getter
@NoArgsConstructor
public class UserDTO {

    @Setter
    private String id;
    @Max(45)
    private String name;
    @Max(45)
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
