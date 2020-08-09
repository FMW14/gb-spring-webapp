package ru.vtb.springapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vtb.springapp.domain.Product;
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

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/products/all";
    }

}
