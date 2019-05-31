package com.example.controller;

import com.example.model.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.service.JokeService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequestMapping("/jokes")
@Controller
public class JokeController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/")
    public String listJokes(Model model){
        model.addAttribute("jokes",jokeService.listAll());
        return "jokes";
    }

}
