package com.example.bookstore.model;

import com.example.bookstore.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue()
    private Integer orderId;


    @OneToOne
    @JoinColumn(name = "cartid")
    public CartDetails cartDetails;

    String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime orderDate;

    public OrderDetails(CartDetails cartDetails, String address, LocalDateTime orderDate) {
        this.cartDetails = cartDetails;
        this.address = address;
        this.orderDate = orderDate;
    }

}
