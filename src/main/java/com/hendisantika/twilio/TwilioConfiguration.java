package com.hendisantika.twilio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.49
 */
@Configuration
@ConfigurationProperties("twilio")
@Data
public class TwilioConfiguration {

    private String accountSid;
    private String authToken;
    private String trialNumber;

}
