package com.hendisantika.service;

import com.hendisantika.model.CartRecords;
import com.hendisantika.repository.CartRepository;
import com.hendisantika.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.37
 */
@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;

    public HashMap<String, String> addToCart(CartRecords cart) {

        HashMap<String, String> hm = new HashMap<>();

        double totPrice = (cart.getPrice() * cart.getQuantity());
        cart.setStatus("P");
        cart.setPrice(totPrice);
        CartRecords add = cartRepository.save(cart);

        if (add != null) {
            hm.put("message", "Success");
        }
        return hm;
    }
}
