package com.backend.study.category.model;

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
}