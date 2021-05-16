package com.bitnet.bitnetgamingnetwork.controller;

import com.bitnet.bitnetgamingnetwork.model.Message;
import com.bitnet.bitnetgamingnetwork.model.Post;
import com.bitnet.bitnetgamingnetwork.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class messageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "/conversation/{sender}/{receiver}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Message> getConversation(@PathVariable("sender") Integer sender, @PathVariable("receiver") Integer receiver) {
        return messageService.getConversation(sender,receiver);
    }
    @PostMapping("/message/send")
    public Message sendMessage(@RequestBody Map<String, Object> payload) {
        // Save as you want as per requiremens


        Integer sender = Integer.parseInt((String) payload.get("sender"));
        Integer receiver = Integer.parseInt((String) payload.get("receiver"));
        String message = (String) payload.get("message");

        Message m = new Message();
        m.setSender(sender);
        m.setReceiver(receiver);
        m.setContent(message);
        return messageService.sendMessage(m);

    }

}
