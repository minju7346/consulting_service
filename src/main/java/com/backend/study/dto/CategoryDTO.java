package com.backend.study.dto;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class CategoryDTO {

    private final BigInteger id;
    private final BigInteger parent_id;
    private final String name;
    private final String description;
    private final byte[] use_yn;
    private final Integer depth;
    private final String creator_id;
    private final String modifier_id;
    private final java.sql.Timestamp created_at;
    private final java.sql.Timestamp modified_at;

}