package com.example.service;


import com.example.model.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JokeService {

    List<Joke> listAll();

    Joke save(Joke joke);

    Joke update(Joke joke);

    Joke fetch(Long id);

    Page<Joke> findPaginated(Pageable pageable);

}
