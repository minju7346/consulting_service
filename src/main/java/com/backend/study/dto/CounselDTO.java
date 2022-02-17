package com.backend.study.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CounselDTO {

    private final long id;
    private final long category_id;
    private final String charger_id;
    private final String title;
    private final String content;
    private final String customer_name;
    private final String customer_email;
    private final String status;
    private final String creator_id;
    private final String modified_id;
    private final LocalDateTime created_at;
    private final LocalDateTime modified_at;

    @Builder
    public CounselDTO(long id, long category_id, String charger_id, String title, String content, String customer_name
    ,String customer_email, String status, String creator_id, String modified_id, LocalDateTime created_at, LocalDateTime modified_at){
        this.id = id;
        this.category_id = category_id;
        this.charger_id = charger_id;
        this.title = title;
        this.content = content;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.status = status;
        this.creator_id = creator_id;
        this.modified_id = modified_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
