package com.hendisantika.stripe;

import com.hendisantika.repository.CartRepository;
import com.hendisantika.service.ItemService;
import com.stripe.Stripe;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.42
 */
@Component
public class StripeClient {

    @Value("${stripe.apikey}")
    private String STRIPE_API_KEY;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    StripeClient() {
        Stripe.apiKey = STRIPE_API_KEY;
    }

    public Customer createCustomer(String token, String email) throws Exception {
        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        customerParams.put("source", token);
        return Customer.create(customerParams);
    }

    private Customer getCustomer(String id) throws Exception {
        return Customer.retrieve(id);
    }
}
