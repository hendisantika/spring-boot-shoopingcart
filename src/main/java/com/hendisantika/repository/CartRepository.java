package com.hendisantika.repository;

import com.hendisantika.model.CartRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.25
 */
@Transactional
@Repository
public interface CartRepository extends JpaRepository<CartRecords, Integer> {
}
