package com.hendisantika.mobilepayment;

import com.hendisantika.repository.CartRepository;
import com.hendisantika.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
