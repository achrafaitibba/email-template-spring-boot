package com.achrafaitibba.mail.mailing;

// Java Program to Create Rest Controller that
// Defines various API for Sending Mail

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

// Annotation
@RestController
// Class
public class EmailController {

    @Autowired private EmailServiceImpl emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public ResponseEntity
    sendMail(@RequestBody EmailDetails details)
    {
        return ResponseEntity.ok(emailService.sendSimpleMail(details));
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailDetails details)
    {
        String status
                = emailService.sendMailWithAttachment(details);

        return status;
    }


    @PostMapping("/send-html-email")
    public String sendHtmlEmail(@RequestBody EmailDetails emailRequest) throws Exception{
        Context context = new Context();
        //context.setVariable("message", emailRequest.getMsgBody());

        emailService.sendEmailWithHtmlTemplate(emailRequest.getRecipient(), emailRequest.getSubject(), "email-template", context);
        return "HTML email sent successfully!";
    }
}
