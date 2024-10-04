package ky.smartgulan.lab1.controller;

import ky.smartgulan.lab1.model.User;
import ky.smartgulan.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    };

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, Model model) {
        String user1 = userService.loginUser(user.getLogin(), user.getPassword());
        model.addAttribute("loginAnswer", user1);
        return "number";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute User user) {
        User registerUser = userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return "register_page";
    }

}
