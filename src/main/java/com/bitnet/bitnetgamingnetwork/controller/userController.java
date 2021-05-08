package com.bitnet.bitnetgamingnetwork.controller;

import com.bitnet.bitnetgamingnetwork.auxClasses.loginResponse;
import com.bitnet.bitnetgamingnetwork.model.User;
import com.bitnet.bitnetgamingnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class userController {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }


    @Autowired
    UserService userService ;

    @RequestMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/users/login",consumes="application/json",produces = "application/json")
    public loginResponse loginUser(@RequestBody Map<String, Object> payload){

        String email = (String) payload.get("email");
        String password = (String) payload.get("password");

        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        return userService.loginUser(u);

    }

    @PostMapping(value = "/users/signup", consumes="application/json",produces = "application/json")
    public User signUpUser(@RequestBody Map<String, Object> payload){

        String email = (String) payload.get("email");
        String password = (String) payload.get("password");
        String name = (String) payload.get("name");
        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
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