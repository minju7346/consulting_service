package com.backend.study.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private final long id;
    private final String name;
    private final String password;
    private final String role;
    private final String status;
    private final String use_yn;
    private final String creator_id;
    private final String modifier_id;
    private final LocalDateTime created_at;
    private final LocalDateTime modified_at;

    @Builder
    public UserDTO(long id, String name, String password, String role, String status, String use_yn, String creator_id, String modifier_id, LocalDateTime created_at, LocalDateTime modified_at){
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.status = status;
        this.use_yn = use_yn;
        this.creator_id = creator_id;
        this.modifier_id = modifier_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
