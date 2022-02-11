package com.backend.study.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class CounselDTO {

    private final BigInteger id;
    private final BigInteger category_id;
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
}
