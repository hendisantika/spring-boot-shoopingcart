package com.hendisantika.service;

import com.hendisantika.model.Item;
import com.hendisantika.repository.CartRepository;
import com.hendisantika.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.39
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    public String deleteItemByID(int id) {
        itemRepository.deleteById(id);
        cartRepository.deleteByItemFromCart(id);
        return "Record deleted";
    }

    public Item updateItemById(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).orElse(null);
        existingItem.setName(item.getName());
        existingItem.setBrand(item.getBrand());
        existingItem.setRam(item.getRam());
        existingItem.setStorage(item.getStorage());
        existingItem.setPrice(item.getPrice());
        existingItem.setStock(item.getStock());
        existingItem.setImgLink(item.getImgLink());
        existingItem.setDescription(item.getDescription());

        return itemRepository.save(existingItem);
    }
}
