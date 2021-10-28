package com.hendisantika.payload.response;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.35
 */
@Data
public class CartResponse {
    private int id;//newly added
    private int itemId;
    private String itemName;
    private int qty;
    private double totalPrice;
    private Date modifiedDate;
}
