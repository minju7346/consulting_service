package com.backend.study.counsel.model;

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

}
