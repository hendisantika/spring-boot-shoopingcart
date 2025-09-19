package com.hendisantika.twilio;

import jakarta.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.47
 *
 * @param phoneNumber destination
 * @param message     message content
 */
public record SmsRequest(@NotBlank String phoneNumber, @NotBlank String message) {
}
