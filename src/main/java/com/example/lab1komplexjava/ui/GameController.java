package com.example.lab1komplexjava.ui;

import com.example.lab1komplexjava.business.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/login")
    public String login(@RequestParam("name") String pname, Model m){
        m.addAttribute("name",pname);
        m.addAttribute("person",gameService.login(pname));
        return "gamePage";
    }

    @PostMapping("/game")
    String guessing(@RequestParam("guess") int guess,Model m) {
        m.addAttribute("answer",gameService.makeGuess(guess));
        boolean gameOver = gameService.isGameDone();
        m.addAttribute("gameOver",gameOver?"You won!":"Wrong Guess!");
        return "gamePage";
    }
    @GetMapping("/results")
    String showResults(Model m){
        m.addAttribute("averageResults",gameService.getAverageResults());
        return "averageTries";
    }
}
