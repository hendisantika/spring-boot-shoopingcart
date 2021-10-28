package com.hendisantika.payload.request;

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
public class CheckAnswer {

    private int userId;

    private int questionPoolId;

    private int questionId;

    private int answeredId;
}
