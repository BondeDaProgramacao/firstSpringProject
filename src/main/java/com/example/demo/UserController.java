/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<User>> createUJser(@RequestBody final List<User> users) {
        for (User user : users) {
            userJPA.save(user);
        }
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUser() {
        List<User> users = userJPA.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) throws Exception {

        Optional<User> user = userJPA.findById(id);

        if (!user.isPresent()) {
            throw new Exception("Usuário não encontrado!");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        userJPA.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateStudent(@RequestBody User user, @PathVariable long id) {

        Optional<User> userOptional = userJPA.findById(id);

        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.setId(id);

        userJPA.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    /*fazer um get por id e um put(update)*/
}
