package com.backend.study.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CategoryDTO {

    private final long id;
    private final long parent_id;
    private final String name;
    private final String description;
    private final String use_yn;
    private final Integer depth;
    private final String creator_id;
    private final String modifier_id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime created_at;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime modified_at;

    @Builder
    public CategoryDTO(long id,long parent_id,String name,String description,String use_yn,Integer depth,String creator_id,String modifier_id,LocalDateTime created_at,LocalDateTime modified_at){
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.description = description;
        this.use_yn = use_yn;
        this.depth = depth;
        this.creator_id = creator_id;
        this.modifier_id = modifier_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

}