package com.backend.study.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChargerDTO {

    private final long category_id;
    private final String user_id;
    private final String creator_id;
    private final LocalDateTime created_at;

    @Builder
    public ChargerDTO(long category_id, String user_id, String creator_id, LocalDateTime created_at){
        this.category_id = category_id;
        this.user_id = user_id;
        this.creator_id = creator_id;
        this.created_at = created_at;
    }
}
