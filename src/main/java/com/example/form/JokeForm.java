package com.example.form;


import com.example.model.Category;

import javax.validation.constraints.NotNull;

public class JokeForm {

    private Long id;

    @NotNull
    private String content;

    @NotNull
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
