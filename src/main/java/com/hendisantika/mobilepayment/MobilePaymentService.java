package com.hendisantika.mobilepayment;

import com.hendisantika.payload.response.CartResponse;
import com.hendisantika.repository.CartRepository;
import com.hendisantika.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.13
 */
@Service
public class MobilePaymentService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemService itemService;

    public String chargeMobilePayment(int userID, List<CartResponse> cartResponseList) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp curentTime = new Timestamp(time);

        cartRepository.updateCartPaymentSuccess(userID, curentTime);

        //Reduce stock when customer paid
        for (CartResponse cartResponse : cartResponseList) {
            itemService.updateStockCustomer(cartResponse.getQty(), cartResponse.getItemId());
        }

        return "success";
    }

}
