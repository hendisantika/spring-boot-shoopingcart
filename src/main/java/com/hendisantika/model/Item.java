package com.hendisantika.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-shoopingcart
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/10/21
 * Time: 06.24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items_tbl")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private int ram;
    private int storage;
    private Double price;
    private String description;
    private String imgLink;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "sellarid")
    private User user;
    private String sellarName;

    @JsonBackReference
    public User getUser() {
        return user;
    }

}
