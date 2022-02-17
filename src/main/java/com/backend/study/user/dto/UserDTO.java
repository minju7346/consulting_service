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

    public UserDTO(String id, String name, String password, String role, String status, String useYn, String creatorId, String modifierId, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
        this.useYn = useYn;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
