package com.backend.study.counsel.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CounselDTO {
    private long id;
    @NotNull
    private long categoryId;
    @Size(min = 1, max = 25)
    private String chargerId;
    @Size(min = 1, max = 45)
    private String title;
    @Size(min = 1, max = 1000)
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
