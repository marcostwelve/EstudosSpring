package com.example.arquiteturaspring.Todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendMail(String msg) {
        System.out.println("Sending mail...");
    }
}
