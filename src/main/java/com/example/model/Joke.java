package com.example.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "JOKE")
public class Joke {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID" )
    private Long id;

    @NotNull
    @Column(name = "CONTENT")
    private String content;

    @Column(name = "LIKES")
    private int likes;

    @Column(name = "DISLIKES")
    private int dislikes;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return likes == joke.likes &&
                dislikes == joke.dislikes &&
                Objects.equals(id, joke.id) &&
                Objects.equals(content, joke.content) &&
                Objects.equals(category, joke.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, likes, dislikes, category);
    }
}
