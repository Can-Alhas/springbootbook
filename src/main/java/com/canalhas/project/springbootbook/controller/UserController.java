package com.canalhas.project.springbootbook.controller;

import com.canalhas.project.springbootbook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books/user**")
public class UserController {

    private final UserService userService;

    @GetMapping("/greet")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi, User");
    }


    }


