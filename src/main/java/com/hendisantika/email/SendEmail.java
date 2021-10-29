package com.hendisantika.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendEmail {
    private String to;
    private String subject;
    private String text;
}
