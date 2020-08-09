package ru.vtb.springapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vtb.springapp.domain.User;
import ru.vtb.springapp.services.UserService;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("frontUsers", userService.getAll());
        return "all_users";
    }

//    @GetMapping("/user")
//    @ResponseBody
//    public User getUser(Model model) {
//        return new User("name1", 10);
//    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/all";
    }

//    @GetMapping("/remove")
//    public String removeUser(Model model) {
//        return "redirect:/users/all";
//    }
}
