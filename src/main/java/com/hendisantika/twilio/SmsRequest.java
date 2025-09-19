package com.hendisantika.twilio;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

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
 */
@AllArgsConstructor
public record SmsRequest(@NotBlank String phoneNumber, @NotBlank String message) {
}
