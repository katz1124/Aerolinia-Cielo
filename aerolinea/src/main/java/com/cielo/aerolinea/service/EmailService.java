package com.cielo.aerolinea.service;

import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface EmailService {
    void send(String from, String to, String title, String body);
    public void sendSimpleMessage(String to, String subject, String text);
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
    public ByteArrayOutputStream createPdfAndSend(final String templateName) throws DocumentException, IOException, DocumentException;

}
