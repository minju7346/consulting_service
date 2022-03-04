package com.backend.study.counsel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CounselDTO {

    private long id;
    @NotNull
    @Max(20)
    private long categoryId;
    @Setter
    @Max(25)
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
