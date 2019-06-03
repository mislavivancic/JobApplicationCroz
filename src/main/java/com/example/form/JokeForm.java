package com.example.form;


import com.example.model.Category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JokeForm {

    private Long id;

    @NotNull
    @Size(min = 1, message = "Vic ne smije biti prazan!")
    private String content;

    @NotNull(message = "Potrebno je odabrati kategoriju!")
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
