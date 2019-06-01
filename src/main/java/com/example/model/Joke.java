package com.example.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "JOKE")
public class Joke {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID" )
    private Long id;


    @Column(name = "CONTENT")
    private String content;

    @Column(name = "LIKES")
    private int likes;

    @Column(name = "DISLIKES")
    private int dislikes;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return likes == joke.likes &&
                dislikes == joke.dislikes &&
                Objects.equals(id, joke.id) &&
                Objects.equals(content, joke.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, likes, dislikes);
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}
