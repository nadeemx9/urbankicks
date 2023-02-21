package com.urbankicks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom("urbankicks.ecommerce@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}
