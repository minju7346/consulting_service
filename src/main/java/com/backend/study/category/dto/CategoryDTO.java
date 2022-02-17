package com.backend.study.category.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private long id;
    private long parentId;
    private String name;
    private String description;
    private String useYn;
    private Integer depth;
    private String creatorId;
    private String modifierId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime modifiedAt;

    private List<CategoryDTO> children;

    public void addChild(CategoryDTO child) {
        if (Objects.isNull(children)) {
            children = new ArrayList<>();
        }

        children.add(child);
    }
    public CategoryDTO(long id, long parentId, String name, String description, String useYn, Integer depth, String creatorId, String modifierId, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.description = description;
        this.useYn = useYn;
        this.depth = depth;
        this.creatorId = creatorId;
        this.modifierId = modifierId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

}