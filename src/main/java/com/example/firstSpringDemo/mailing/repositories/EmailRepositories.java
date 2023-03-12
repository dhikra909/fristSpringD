package com.example.firstSpringDemo.mailing.repositories;

import com.example.firstSpringDemo.mailing.models.EmailDetails;

public interface EmailRepositories {

    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);






}
