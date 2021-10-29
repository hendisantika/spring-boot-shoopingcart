package com.hendisantika.controller;

import com.hendisantika.model.CartRecords;
import com.hendisantika.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.32
 */
@CrossOrigin("*")
@RequestMapping("/api/cart")
@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public HashMap<String, String> addToCart(@RequestBody CartRecords cart) throws Exception {
        HashMap<String, String> response = cartService.addToCart(cart);
        return response;
    }
}
