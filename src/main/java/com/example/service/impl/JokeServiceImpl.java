package com.example.service.impl;

import com.example.model.Joke;
import com.example.repository.JokeRepository;
import com.example.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public Joke update(Joke joke) {
        return jokeRepository.save(joke);
    }

    @Override
    public Joke fetch(Long id) {
        return jokeRepository.findById(id).get();
    }

    @Override
    public Page<Joke> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Joke> list;
        List<Joke> jokes = jokeRepository.findAll();
        Collections.sort(jokes, (a, b) -> a.getLikes() - a.getDislikes() > b.getLikes() - b.getDislikes() ? -1 : 1);


        if (jokes.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, jokes.size());
            list = jokes.subList(startItem, toIndex);
        }

        Page<Joke> jokePage
                = new PageImpl<Joke>(list, PageRequest.of(currentPage, pageSize), jokes.size());

        return jokePage;
    }
}
