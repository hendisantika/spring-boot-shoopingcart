package com.hendisantika.stripe;

import com.hendisantika.repository.CartRepository;
import com.hendisantika.service.ItemService;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
}
