package com.aleksei.alm.server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private Senders sender;

    private String text;

    private String timestamp;

}

