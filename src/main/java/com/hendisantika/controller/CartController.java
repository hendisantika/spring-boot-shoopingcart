package com.hendisantika.controller;

import com.hendisantika.model.CartRecords;
import com.hendisantika.payload.response.CartResponse;
import com.hendisantika.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/{custId}")
    @PreAuthorize("hasRole('USER')")
    public List<CartResponse> getAllItemsInCart(@PathVariable int custId) {
        return cartService.getAllItemsInCart(custId);
    }

    @GetMapping("/{custId}/{id}")
    @PreAuthorize("hasRole('USER')")
    public List<CartRecords> getItemInCartById(@PathVariable int custId, @PathVariable int itemId) {
        return cartService.getItemInCartById(custId, itemId);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public String deleteItemInCartById(@PathVariable int id) {
        return cartService.deleteItemByID(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public CartRecords updateItemInCart(@RequestBody CartRecords cart) {
        return cartService.updateItemById(cart);
    }

}
