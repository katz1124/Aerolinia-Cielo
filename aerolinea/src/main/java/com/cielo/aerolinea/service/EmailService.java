package com.cielo.aerolinea.service;

public interface EmailService {
    void send(String from, String to, String title, String body);
    public void sendSimpleMessage(String to, String subject, String text);
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);


}
