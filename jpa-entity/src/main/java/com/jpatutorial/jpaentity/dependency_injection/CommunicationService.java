package com.jpatutorial.jpaentity.dependency_injection;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
//@NoArgsConstructor
public class CommunicationService {

//    private final SMSService iSender = new SMSService();

    private final ISender iSender;

    public CommunicationService(ISender iSender) {
        this.iSender = iSender;
    }

    public String sendService(String message, String receiver) {
        return iSender.send(message, receiver);
    }
}
