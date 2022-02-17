package com.backend.study.counsel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CounselHistoryDTO {

    private long counselId;
    private long sequence;
    private long categoryId;
    private String title;
    private String content;
    private String requestorEmail;
    private String chargerId;
    private String status;
    private String creatorId;
    private LocalDateTime createdAt;

    public CounselHistoryDTO(long counselId, long sequence, long categoryId, String title, String content, String requestorEmail,
                      String chargerId, String status, String creatorId, LocalDateTime createdAt){
        this.counselId = counselId;
        this.sequence = sequence;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.requestorEmail = requestorEmail;
        this.chargerId = chargerId;
        this.status = status;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
    }
}
