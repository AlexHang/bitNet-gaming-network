package com.bitnet.bitnetgamingnetwork.services;

import com.bitnet.bitnetgamingnetwork.model.Message;
import com.bitnet.bitnetgamingnetwork.repositories.messageRepository;
import com.bitnet.bitnetgamingnetwork.repositories.postRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    @Autowired
    private final messageRepository messageRepo;

    public List<Message> getConversation(Integer sender, Integer receiver){

        List<Message> aux = messageRepo.findAllBySenderOrReceiver(sender,receiver);
        aux.addAll(messageRepo.findAllBySenderOrReceiver(receiver,sender));
        Collections.sort(aux);
        return aux ;
    }

    public Message sendMessage(Message m){
        return messageRepo.save(m);
    }

}
