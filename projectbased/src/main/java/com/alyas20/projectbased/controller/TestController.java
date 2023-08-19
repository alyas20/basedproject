package com.alyas20.projectbased.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/api/book")
public class TestController {

    @GetMapping("/{id}")
    public String findById(@PathVariable long id) {
        return new String("Test");
    }
}
