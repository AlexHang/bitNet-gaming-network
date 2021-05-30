package com.bitnet.bitnetgamingnetwork.repositories;
import com.bitnet.bitnetgamingnetwork.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface commentRepository  extends CrudRepository<Comment, Integer> {
    List<Comment> findAllByPostId(Integer postId);
    <S extends Comment> S save(S entity);
}
