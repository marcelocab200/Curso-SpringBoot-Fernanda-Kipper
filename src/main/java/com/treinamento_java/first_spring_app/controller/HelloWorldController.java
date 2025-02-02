package com.treinamento_java.first_spring_app.controller;

import com.treinamento_java.first_spring_app.domain.User;
import com.treinamento_java.first_spring_app.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Marcelo");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(
            @PathVariable() String id,
            @RequestBody User body,
            @RequestParam(value = "filter", defaultValue = "noFilter") String filter
    ) {
        return "Hello World " + body.getName() + ", id: " + id + ", email: " + body.getEmail() + ", filter: " + filter;
    }
}
