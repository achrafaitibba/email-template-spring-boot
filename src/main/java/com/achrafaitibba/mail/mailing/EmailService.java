package com.achrafaitibba.mail.mailing;

// Importing required classes

import org.thymeleaf.context.Context;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    Void sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);

    void sendEmailWithHtmlTemplate(String to, String subject, String templateName, Context context)throws Exception;
}
