package com.hendisantika.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.33
 */
@Data
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
