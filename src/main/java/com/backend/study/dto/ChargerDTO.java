package com.backend.study.dto;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class ChargerDTO {

    private final BigInteger category_id;
    private final String user_id;
    private final String creator_id;
    private final LocalDateTime created_at;
}
