package com.example.student_crud_application_mysql.controller;

import com.example.student_crud_application_mysql.entity.User;
import com.example.student_crud_application_mysql.exception.UserNotFoundException;
import com.example.student_crud_application_mysql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
        @Autowired
    private UserRepository userRepository;
        @PostMapping("/user")
    User newUser(@RequestBody User newUser){
            return userRepository.save(newUser);
        }
        @GetMapping("/users")
    List<User> getalluser(){
            return userRepository.findAll();
        }

        @GetMapping("/user/{id}")
    User getuserbyid(@PathVariable Long id){
            return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        }

        @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
            return userRepository.findById(id).map(user -> {
                user.setUsername(newUser.getUsername());
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                return userRepository.save(user);
            }).orElseThrow(()->new UserNotFoundException(id));
        }

        @DeleteMapping("/user/{id}")
    String deleteuser(@PathVariable Long id){
            if(!userRepository.existsById(id)){
                throw new UserNotFoundException(id);
            }
            userRepository.deleteById(id);
            return"User with id "+id+" has been deleted success";
        }
}



