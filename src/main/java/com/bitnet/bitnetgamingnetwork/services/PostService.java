package com.bitnet.bitnetgamingnetwork.services;


import com.bitnet.bitnetgamingnetwork.model.Post;
import com.bitnet.bitnetgamingnetwork.repositories.postRepository;
import com.bitnet.bitnetgamingnetwork.repositories.userRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {



    final String UPLOADED_FOLDER = "posts/media";

    @Autowired
    private final postRepository postRepo;

    public List<Post> getAllPosts(){
        return  postRepo.findAll();
    }

    public Post getPostById(Integer postId){return  postRepo.findPostById(postId);}

    public String saveUploadedFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            return UPLOADED_FOLDER + file.getOriginalFilename();
        }
        return "";
    }

    public Post createPost(String title, Integer authorId, String description, String file) {

        Post p = new Post();
        p.setTitle(title);
        p.setAuthorId(authorId);
        p.setDescription(description);
        p.setMediaURL(file);

        postRepo.save(p);

        return p;
    }

}
