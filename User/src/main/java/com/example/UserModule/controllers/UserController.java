package com.example.UserModule.controllers;

import com.example.UserModule.entities.User;
import com.example.UserModule.services.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserImpl userSerivce;

    @PostMapping("user/create")
    public ResponseEntity<User> createUser(@RequestBody User reservationEquipement) {
        User createduser = userSerivce.createUser(reservationEquipement);
        return new ResponseEntity<>(createduser, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> createduser = userSerivce.getUserById(id);
        if (createduser != null) {
            return new ResponseEntity<>(createduser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = userSerivce.getUserById(id);
        if (existingUser != null) {
            user.setId(id);
            User updatedUser = userSerivce.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        Optional<User> user = userSerivce.getUserById(id);
        if (user != null) {
            userSerivce.deleteUser(user.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

