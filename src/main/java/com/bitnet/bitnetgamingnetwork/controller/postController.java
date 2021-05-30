package com.bitnet.bitnetgamingnetwork.controller;


import com.bitnet.bitnetgamingnetwork.model.Comment;
import com.bitnet.bitnetgamingnetwork.model.Post;
import com.bitnet.bitnetgamingnetwork.model.User;
import com.bitnet.bitnetgamingnetwork.services.PostService;
import com.bitnet.bitnetgamingnetwork.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@SpringBootApplication
@RestController
public class postController {

    @Autowired
    PostService postService;

    @RequestMapping("/post/all")
    public List<Post> getAllUsers(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/post/getPost/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Post getPostById(@PathVariable("postId") Integer postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/post/upload")
    public Post multiUploadFileModel(@RequestBody Map<String, Object> payload) {
        // Save as you want as per requiremens

        String title = (String) payload.get("title");
        Integer authorId = Integer.parseInt((String) payload.get("authorId"));
        String description = (String) payload.get("description");
        String url = (String) payload.get("mediaURL");
        return postService.createPost(title, authorId, description, url);

    }

}
