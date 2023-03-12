package com.example.firstSpringDemo.controler;

import com.example.firstSpringDemo.mailing.models.EmailDetails;
import com.example.firstSpringDemo.mailing.service.Emailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Email")
public class EmailController {

    @Autowired
    Emailservice email;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails emailDetails) {
        String status = email.sendSimpleMail(emailDetails);
        return status;
    }

    @PostMapping("/sendMailToMany")
    public String sendMailToMany(@RequestBody EmailDetails emailDetails) {
        String status = email.sendSimpleMailToMany(emailDetails);
        return status;
    }


    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails) {
        String status = email.sendMailWithAttachment(emailDetails);
        return status;
    }


    @PostMapping("/sendMailWithAttachmentToMany")
    public String sendMailWithAttachmentToMany(@RequestBody EmailDetails emailDetails) {
        String status = email.sendMailWithAttachmentToMany(emailDetails);
        return status;
    }

}
