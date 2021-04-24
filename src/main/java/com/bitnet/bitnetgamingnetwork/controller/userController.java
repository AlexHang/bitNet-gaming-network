package com.bitnet.bitnetgamingnetwork.controller;

import com.bitnet.bitnetgamingnetwork.auxClasses.loginResponse;
import com.bitnet.bitnetgamingnetwork.model.User;
import com.bitnet.bitnetgamingnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {

    @Autowired
    UserService userService ;

    @RequestMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/users/login")
    public loginResponse loginUser(@RequestParam("email") String email, @RequestParam("password") String password){

        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        return userService.loginUser(u);

    }

    @PostMapping("/users/signup")
    public User signUpUser(@RequestParam("email") String email, @RequestParam("password") String pass, @RequestParam("name") String name){

        User u = new User();
        u.setEmail(email);
        u.setPassword(pass);
        u.setName(name);
        User aux;

        if(!userService.userExists(u.getEmail())){
            aux = userService.createUser(u);
        }else{
            aux = new User();
            aux.setId(-1);
            aux.setEmail("user already exists");
        }

        return aux;

    }


}