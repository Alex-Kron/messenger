package com.aleksei.alm.server.service;

import com.aleksei.alm.server.model.Message;
import com.aleksei.alm.server.model.Senders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ShellComponent
@Slf4j
public class ShellService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Value("${server.channel}")
    private String channel;

    @ShellMethod(value = "Send messages from Server CLI to Client")
    public void send(@ShellOption(value = "-m") String message) {
        log.info("Send message to subscribers...");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);
        Message reply = Message.builder()
                .sender(Senders.SERVER)
                .text(message)
                .timestamp(time)
                .build();
        log.info("Sending a reply: {}", reply);
        simpMessagingTemplate.convertAndSend(channel, reply);
        log.info("Message sent.");
    }
}
