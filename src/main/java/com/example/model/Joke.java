package com.example.model;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "JOKE")
@Getter
@Setter
@NoArgsConstructor
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
