package com.bitnet.bitnetgamingnetwork.services;

import com.bitnet.bitnetgamingnetwork.auxClasses.loginResponse;
import com.bitnet.bitnetgamingnetwork.model.User;
import com.bitnet.bitnetgamingnetwork.repositories.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final userRepository userRepo;


    public boolean userExists(final String email){

        User user = userRepo.findUserByEmail(email);
        return user!=null;

    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User createUser(User u){

        u.setPassword(getHash(u.getPassword()));
        Integer id = userRepo.save(u).getId();
        return userRepo.findUserById(id);
    }

    public loginResponse loginUser(User u){

        loginResponse response;

        User aux = userRepo.findUserByEmailAndPassword(u.getEmail(), getHash(u.getPassword()));
        if(aux.getId()!=null){
            response = new loginResponse(aux.getId(),true);
        }else{
            response =  new loginResponse(-1,false);
        }

        return response;

    }

    public static String getHash(String password) {
        MessageDigest digest=null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        digest.reset();
        try {
            digest.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return new BigInteger(1, digest.digest()).toString(16);
    }

}
