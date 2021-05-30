package com.bitnet.bitnetgamingnetwork.controller;

import com.bitnet.bitnetgamingnetwork.model.Comment;
import com.bitnet.bitnetgamingnetwork.model.Message;
import com.bitnet.bitnetgamingnetwork.model.Post;
import com.bitnet.bitnetgamingnetwork.services.CommentService;
import com.bitnet.bitnetgamingnetwork.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class commentController {

    @Autowired
    CommentService commentService;

    @GetMapping(value = "/comments/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getConversation(@PathVariable("postId") Integer postId) {
        return commentService.getPostComments(postId);
    }

    @PostMapping("/comments/add")
    public Comment sendMessage(@RequestBody Map<String, Object> payload) {
        // Save as you want as per requiremens


        Integer authorId = Integer.parseInt((String) payload.get("userId"));
        Integer postId = Integer.parseInt((String) payload.get("postId"));
        String content = (String) payload.get("content");

        Comment c = new Comment();
        c.setAuthorId(authorId);
        c.setPostId(postId);
        c.setContent(content);
        return commentService.createComment(c);

    }

}
