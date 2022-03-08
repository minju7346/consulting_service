package com.backend.study.counsel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class CounselDTO {
    private long id;
    @NotNull
    private long categoryId;
    @Length(min = 1, max = 25)
    private String chargerId;
    @Length(min = 1, max = 45)
    private String title;
    @Length(min = 1, max = 1000)
    private String content;
    @NotNull
    @Size(min = 1, max = 45)
    private String customerName;
    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$")
    private String customerEmail;
    private String status;
    private String creatorId;
    private String modifierId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public void bindChargerId(String id) {
        this.chargerId = id;
    }

}
