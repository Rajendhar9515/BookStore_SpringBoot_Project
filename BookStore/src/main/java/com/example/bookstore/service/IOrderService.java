package com.example.bookstore.service;

import com.example.bookstore.dto.OrderDTO;

public interface IOrderService {
    Object saveAll(OrderDTO orderDTO);

    Object display();

    Object deleteById(int id);


}
