package com.hendisantika.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.17
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/mail/send")
public class MailController {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping
    public void sendMessage(@RequestBody SendEmail sendEmail) {
        sendEmailService.sendMessage(sendEmail.getTo(), sendEmail.getSubject(), sendEmail.getText());
    }
}
