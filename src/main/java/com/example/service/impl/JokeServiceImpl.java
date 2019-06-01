package com.example.service.impl;

import com.example.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.JokeRepository;
import com.example.service.JokeService;

import java.util.List;

@Service
public class JokeServiceImpl implements JokeService{

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public List<Joke> listAll() {
        return jokeRepository.findAll();
    }

    @Override
    public Joke save(Joke joke) {
        return jokeRepository.save(joke);
    }
}
