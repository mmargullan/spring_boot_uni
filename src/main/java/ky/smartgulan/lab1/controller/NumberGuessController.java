package ky.smartgulan.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/guess")
public class NumberGuessController {

    @GetMapping
    public String numberGuess(Model model) {
        return "number";
    }

    @PostMapping("/submit")
    public String numberGuess(@RequestParam("number") int number, Model model) {
        model.addAttribute("number", number);
        return "number";
    }
}
