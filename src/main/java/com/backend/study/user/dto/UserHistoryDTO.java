package com.backend.study.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserHistoryDTO {

    private String UserId;
    private long sequence;
    private String name;
    private String password;
    private String role;
    private String status;
    private String useYn;
    private String creatorId;
    private LocalDateTime createdAt;

    public UserHistoryDTO(String UserId, long sequence, String name, String password, String role, String status, String useYn, String creatorId, LocalDateTime createdAt){
        this.UserId = UserId;
        this.sequence = sequence;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
        this.useYn = useYn;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }
}
