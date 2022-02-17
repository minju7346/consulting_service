package com.backend.study.counsel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CounselDTO {

    private long id;
    private long categoryId;
    private String chargerId;
    private String title;
    private String content;
    private String customerName;
    private String customerEmail;
    private String status;
    private String creatorId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CounselDTO(long id, long categoryId, String chargerId, String title, String content, String customerName
    ,String customerEmail, String status, String creatorId, String modifierId, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.categoryId = categoryId;
        this.chargerId = chargerId;
        this.title = title;
        this.content = content;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.status = status;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
