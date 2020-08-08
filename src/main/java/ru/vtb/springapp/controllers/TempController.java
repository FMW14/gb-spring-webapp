package ru.vtb.springapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TempController {
    // GET http://localhost:8189/app/temp
    @RequestMapping(value = "/temp", method = RequestMethod.GET)
    public String showTempPage() {
        return "temp-page";
    }

    // GET http://localhost:8189/app/simple_str
    @RequestMapping(value = "/simple_str", method = RequestMethod.GET)
    @ResponseBody
    public String showSimpleString() {
        return "Hello, World!!!";
    }

    // POST http://localhost:8189/app/simple_post
    // @RequestMapping(value = "/simple_post", method = RequestMethod.POST)
    @PostMapping("/simple_post")
    @ResponseBody
    public String simplePostRequest() {
        return "Post request";
    }

    // GET http://localhost:8189/app/hello?name=Bob
    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(@RequestParam(required = false) String name, @RequestParam(required = false) String surname) {
        if (name == null && surname == null) {
            return "Hello, stranger!!!";
        }
        StringBuilder resultName = new StringBuilder();
        if (name != null) {
            resultName.append(name).append(" ");
        }
        if (surname != null) {
            resultName.append(surname);
        } else {
            resultName.setLength(resultName.length() - 1);
        }
        return String.format("Hello, %s!!!", resultName.toString());
    }

    @GetMapping("/show_product/{id}/show")
    @ResponseBody
    public String showProductById(@PathVariable Long id) {
        return "Product #" + id;
    }
}
