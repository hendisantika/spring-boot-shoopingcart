package com.hendisantika.twilio;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.47
 */
@Data
@AllArgsConstructor
public class SmsRequest {
    @NotBlank
    private final String phoneNumber; // destination

    @NotBlank
    private final String message;

}
