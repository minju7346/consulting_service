package com.backend.study.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDTO {

    private final BigInteger id;
    private final String name;
    private final String password;
    private final String role;
    private final String status;
    private final byte[] use_yn;
    private final String creator_id;
    private final String modifier_id;
    private final java.sql.Timestamp created_at;
    private final java.sql.Timestamp modified_at;

}
