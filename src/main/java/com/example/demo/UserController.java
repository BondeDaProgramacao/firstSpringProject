/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camila.dos.s.fraga
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userJPA;

    @Autowired
    public void setUserRepo(UserRepository userJpaRepo) {
        this.userJPA = userJpaRepo;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUJser(@RequestBody final User user) {
        userJPA.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userJPA.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
}
