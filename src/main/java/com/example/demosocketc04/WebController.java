package com.example.demosocketc04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void greeting(User user) throws Exception {
        simpMessagingTemplate.convertAndSend("/topic/public", new Hello(user.getName() +" : " + user.getMessage()));
    }
}
