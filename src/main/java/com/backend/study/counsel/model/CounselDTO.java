package com.backend.study.counsel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CounselDTO {

    private long id;
    private long categoryId;
    @Setter
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
