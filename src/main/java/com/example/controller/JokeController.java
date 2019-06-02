package com.example.controller;

import com.example.form.JokeForm;
import com.example.model.Joke;
import com.example.repository.CategoryRepository;
import com.example.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/new")
    public String addJoke(Model model){
        model.addAttribute("jokeForm", new JokeForm());
        model.addAttribute("categories",categoryRepository.findAll());
        return "newJoke";
    }
    @PostMapping("/new")
    public String addedJoke(@ModelAttribute JokeForm jokeForm) {
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        joke.setCategory(jokeForm.getCategory());
        jokeService.save(joke);
        return "jokeAdded";
    }

    @GetMapping("")
    public String allJokes(Model model){
        model.addAttribute("jokes",jokeService.listAll());
        return "allJokes";
    }

    public void onClick(Long jokeId){
        System.out.print("aaa\n");
    }





}
