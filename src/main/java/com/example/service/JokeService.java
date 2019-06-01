package com.example.service;


import com.example.model.Joke;

import java.util.List;

public interface JokeService {

    List<Joke> listAll();

    Joke save(Joke joke);

}
