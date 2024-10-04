package ky.smartgulan.lab1.controller;


import ky.smartgulan.lab1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/task")
public class TaskController {

    private final UserService userService;

    public TaskController(UserService userService) {
        this.userService = userService;
    }

    // Task 1
    @GetMapping("/currentTime")
    public String currentTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    // Task 2
    @GetMapping("/api")
    public List<Integer> api(@RequestParam(name = "q") int q) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= q; i++) {
            list.add(i);
        }
        return list;
    }

    // Task 3
    @GetMapping("/randomNumber")
    public int randomNumber(){
        Random random = new Random();
        return random.nextInt(501);
    }

    // Task 4
    @GetMapping("/fib")
    public String fib(@RequestParam(name = "n") int n) {
        int x = 1;
        int y = 1;
        for (int i = 1; i <= n; i++){
            x = x + y;
            y = x - y;
        }
        return Integer.toString(x);
    }

    // Task 5
    @GetMapping("/reverse/{word}")
    public String reverse(@PathVariable(name = "word") StringBuilder word) {
        return word.reverse().toString();
    }
}
