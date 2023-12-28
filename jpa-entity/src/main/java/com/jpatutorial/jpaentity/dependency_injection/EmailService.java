package com.jpatutorial.jpaentity.dependency_injection;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements ISender {

    @Override
    public String send(String message, String receiver) {
        return String.format("Email sent to %s with message=%s", receiver, message);
    }
}
