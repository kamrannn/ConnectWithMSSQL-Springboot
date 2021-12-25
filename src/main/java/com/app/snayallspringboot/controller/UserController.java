package com.app.snayallspringboot.controller;

import com.app.snayallspringboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String getName(){
        return "Working";
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getUsers(){
        return userService.listOfUsers();
    }

    @GetMapping("/userbyid")
    public ResponseEntity<Object> getUsers(@RequestParam int id){
        return userService.findUserById(id);
    }
}
