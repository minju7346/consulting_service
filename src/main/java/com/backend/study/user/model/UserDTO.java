package com.backend.study.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String id;
    @Size(min = 1, max = 25)
    private String name;
    @Size(min = 1, max = 45)
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
