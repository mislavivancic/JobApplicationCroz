package com.example.controller;

import com.example.form.JokeForm;
import com.example.model.Joke;
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

    @GetMapping("/new")
    public String listJokes(Model model){
        model.addAttribute("jokeForm", new JokeForm());
        System.out.println("tu sam bio");
        return "newJoke";
    }
    @PostMapping("/new")
    public String greetingSubmit(@ModelAttribute JokeForm jokeForm) {
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        jokeService.save(joke);
        return "jokeAdded";
    }



}
