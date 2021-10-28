package com.hendisantika.repository;

import com.hendisantika.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.29
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Transactional
    @Query("UPDATE Item SET stock = stock - ?1 WHERE id = ?2")
    @Modifying
    void updateStockCustomer(int quantity, int id);

    @Transactional
    @Query("UPDATE Item SET stock = stock + ?1 WHERE id = ?2")
    @Modifying
    void updateStockSellar(int quantity, int id);

    @Query(value = "SELECT * from items_tbl it WHERE  it.sellarid = ?1 ", nativeQuery = true)
    List<Item> getAllItemsBySellarID(int sellarid);

}
