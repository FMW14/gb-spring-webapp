package ru.vtb.springapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.vtb.springapp.domain.User;
import ru.vtb.springapp.services.ProductService;
import ru.vtb.springapp.services.UserService;

@AllArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("frontProducts", productService.getAll());
        return "all_products";
    }

    @GetMapping("/remove")
    public String removeUser(Model model) {

        return "redirect:/users/all";
    }
}
