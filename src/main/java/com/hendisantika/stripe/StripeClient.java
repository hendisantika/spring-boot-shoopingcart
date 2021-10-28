package com.hendisantika.stripe;

import com.hendisantika.payload.response.CartResponse;
import com.hendisantika.repository.CartRepository;
import com.hendisantika.service.ItemService;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    public Charge chargeNewCard(String token, double amount, int userID, List<CartResponse> cartResponseList) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int) (amount * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);

        Date date = new Date();
        long time = date.getTime();
        Timestamp curentTime = new Timestamp(time);

        cartRepository.updateCartPaymentSuccess(userID, curentTime);

        //Reduce stock when customer paid
        for (CartResponse cartResponse : cartResponseList) {
            itemService.updateStockCustomer(cartResponse.getQty(), cartResponse.getItemId());
        }

        return charge;
    }
}
