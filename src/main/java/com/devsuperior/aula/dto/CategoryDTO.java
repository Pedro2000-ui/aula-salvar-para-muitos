package com.devsuperior.aula.dto;

import com.devsuperior.aula.entities.Category;

public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO() {}

    public CategoryDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public CategoryDTO(Category category) {
        this.name = category.getName();
        this.id = category.getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
