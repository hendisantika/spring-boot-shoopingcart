package com.hendisantika.controller;

import com.hendisantika.mobilepayment.MobilePaymentService;
import com.hendisantika.payload.response.CartResponse;
import com.hendisantika.stripe.StripeClient;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.37
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/payment")
public class PaymentGatewayController {
    private final StripeClient stripeClient;

    @Autowired
    private MobilePaymentService mobilePaymentService;

    @Autowired
    PaymentGatewayController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Charge chargeCard(@RequestHeader(value = "token") String token,
                             @RequestHeader(value = "amount") Double amount,
                             @RequestHeader(value = "userid") Integer userid,
                             @RequestBody List<CartResponse> cartResponseList) throws Exception {
        return this.stripeClient.chargeNewCard(token, amount, userid, cartResponseList);
    }

}
