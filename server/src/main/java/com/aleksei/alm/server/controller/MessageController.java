package com.aleksei.alm.server.controller;

import com.aleksei.alm.server.model.Message;
import com.aleksei.alm.server.model.Senders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
public class MessageController {

    @MessageMapping("${server.endpoint}")
    @SendTo("/topic/messages")
    public Message onMessage(Message message) throws Exception {
        log.info("Message received from client: {}", message);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);
        log.info("Sending a reply");
        return Message.builder()
                .sender(Senders.SERVER)
                .text("MESSAGE RECEIVED")
                .timestamp(time)
                .build();
    }

    @SubscribeMapping("${server.subscription}")
    public Message onSubscribe() {
        log.info("Client subscribe on chanel");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);
        return Message.builder()
                .sender(Senders.SERVER)
                .text("SUCCESSFUL SUBSCRIBE")
                .timestamp(time)
                .build();
    }
}
