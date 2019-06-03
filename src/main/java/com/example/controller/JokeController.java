package com.example.controller;

import com.example.form.JokeForm;
import com.example.model.Joke;
import com.example.repository.CategoryRepository;
import com.example.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/new")
    public String addJoke(Model model) {
        model.addAttribute("jokeForm", new JokeForm());
        model.addAttribute("categories", categoryRepository.findAll());
        return "newJoke";
    }

    @PostMapping("/new")
    public String addedJoke(@Valid @ModelAttribute JokeForm jokeForm, BindingResult bindingResult, Model model) {
        System.out.print("aa");
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryRepository.findAll());
            return "newJoke";
        }
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        joke.setCategory(jokeForm.getCategory());
        jokeService.save(joke);
        return "jokeAdded";
    }

    @GetMapping("")
    public String allJokes(Model model) {
        List<Joke> jokesList = jokeService.listAll();
        Collections.sort(jokesList, (a, b) -> a.getLikes() - a.getDislikes() > b.getLikes() - b.getDislikes() ? -1 : 1);
        model.addAttribute("jokes", jokesList);
        return "allJokes";
    }

    @PostMapping("/upvote")
    public String upvote(@RequestParam("jokeId") Long jokeId, Model model) {
        Joke joke = jokeService.fetch(jokeId);
        joke.setLikes(joke.getLikes() + 1);
        jokeService.update(joke);
        List<Joke> jokesList = jokeService.listAll();
        Collections.sort(jokesList, (a, b) -> a.getLikes() - a.getDislikes() > b.getLikes() - b.getDislikes() ? -1 : 1);
        model.addAttribute("jokes", jokesList);
        return "allJokes";
    }

    @PostMapping("/downvote")
    public String downvote(@RequestParam("jokeId") Long jokeId, Model model) {
        Joke joke = jokeService.fetch(jokeId);
        joke.setDislikes(joke.getDislikes() + 1);
        jokeService.update(joke);
        List<Joke> jokesList = jokeService.listAll();
        Collections.sort(jokesList, (a, b) -> a.getLikes() - a.getDislikes() > b.getLikes() - b.getDislikes() ? -1 : 1);
        model.addAttribute("jokes", jokesList);
        return "allJokes";
    }


}
