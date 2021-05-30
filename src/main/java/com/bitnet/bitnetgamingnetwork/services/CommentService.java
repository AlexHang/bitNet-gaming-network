package com.bitnet.bitnetgamingnetwork.services;

import com.bitnet.bitnetgamingnetwork.model.Comment;
import com.bitnet.bitnetgamingnetwork.model.Message;
import com.bitnet.bitnetgamingnetwork.repositories.commentRepository;
import com.bitnet.bitnetgamingnetwork.repositories.messageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentService {

    @Autowired
    private final commentRepository commentRepo;


    public List<Comment> getPostComments(Integer postId){
        return commentRepo.findAllByPostId(postId);
    }

    public Comment createComment(Comment c){
        return commentRepo.save(c);
    }
}
