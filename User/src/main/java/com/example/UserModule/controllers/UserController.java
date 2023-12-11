package com.example.UserModule.controllers;

import com.example.UserModule.entities.User;
import com.example.UserModule.services.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
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

    @GetMapping("/user/one/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> createduser = userSerivce.getUserById(id);
        if (createduser.isPresent()) {
            return new ResponseEntity<>(createduser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
       return userSerivce.getAllUsers();
    }

    @PostMapping("user/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        if(user.getEmail()==null|| user.getPassword()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<User> us = userSerivce.login(user.getEmail(), user.getPassword());
        if(us.isPresent()){
            return new ResponseEntity<>(us.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = userSerivce.getUserById(id);
        if (existingUser.isPresent()) {
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

