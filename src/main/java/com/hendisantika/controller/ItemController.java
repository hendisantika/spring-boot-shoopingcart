package com.hendisantika.controller;

import com.hendisantika.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 30/10/21
 * Time: 06.34
 */
@CrossOrigin("*")
@RequestMapping(value = "/api/item")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
}
