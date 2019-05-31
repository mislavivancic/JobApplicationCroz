package com.example.repository;

import com.example.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JokeRepository extends JpaRepository<Joke,Long> {

    Optional<Joke> findById(Long id);

}
