package com.hendisantika.service;

import com.hendisantika.model.CartRecords;
import com.hendisantika.model.Item;
import com.hendisantika.payload.response.CartResponse;
import com.hendisantika.repository.CartRepository;
import com.hendisantika.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<CartResponse> getAllItemsInCart(int id) {
        List<CartRecords> cart = cartRepository.getCartDetailsByCustId(id);
        List<CartResponse> cartResponse = new ArrayList<CartResponse>();

        for (CartRecords cartRes : cart) {
            CartResponse response = new CartResponse();
            response.setQty(cartRes.getQuantity());
            response.setTotalPrice(cartRes.getPrice());
            response.setId(cartRes.getId());
            response.setItemId(cartRes.getItemId());

            Item existingItem = itemRepository.findById(cartRes.getItemId()).orElse(null);
            response.setItemName(existingItem.getName());

            cartResponse.add(response);
        }
        return cartResponse;
    }

    public List<CartRecords> getItemInCartById(int custId, int id) {
        return cartRepository.getCartDetailsByCustIdAndId(custId, id);
    }

}
