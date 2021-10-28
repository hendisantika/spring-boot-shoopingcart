package com.hendisantika.repository;

import com.hendisantika.model.CartRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.25
 */
@Repository
public interface CartRepository extends JpaRepository<CartRecords, Integer> {
    @Query(value = "SELECT * from cart_item c WHERE c.user_id = ?1 AND c.status = '" + "P" + "'", nativeQuery = true)
    List<CartRecords> getCartDetailsByCustId(int custId);

    @Query(value = "SELECT * from cart_item c WHERE c.user_id = ?1 AND c.item_id = ?2", nativeQuery = true)
    List<CartRecords> getCartDetailsByCustIdAndId(int custId, int id);

    @Query(value = "SELECT * from cart_item c WHERE c.user_id = ?1 AND c.status = '" + "S" + "'", nativeQuery = true)
    List<CartRecords> getPayedCartDetailsByCustId(int custId);

}
