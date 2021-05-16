package com.bitnet.bitnetgamingnetwork.repositories;

import com.bitnet.bitnetgamingnetwork.model.Message;
import com.bitnet.bitnetgamingnetwork.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface messageRepository extends CrudRepository<Message, Integer> {
    List<Message> findAll();
    List<Message> findAllBySenderOrReceiver(Integer Sender, Integer Receiver);
    <S extends Message> S save(S entity);
}
