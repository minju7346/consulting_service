package com.backend.study.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String password;
    private String role;
    private String status;
    private String useYn;
    private String creatorId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
