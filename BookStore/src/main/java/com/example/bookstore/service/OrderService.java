package com.example.bookstore.service;

import com.example.bookstore.dto.OrderDTO;
import com.example.bookstore.exceptionalHandler.BookStoreException;
import com.example.bookstore.model.CartDetails;
import com.example.bookstore.model.OrderDetails;
import com.example.bookstore.repository.CartRepo;
import com.example.bookstore.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    CartRepo cartRepo;

    public OrderDetails saveAll(OrderDTO orderDTO) {
        Optional<CartDetails> cartData = cartRepo.findById(orderDTO.getCart_id());
        if (cartData.isPresent()) {
            LocalDateTime orderDate = LocalDateTime.now();
            OrderDetails orderDetails = new OrderDetails(cartData.get(), orderDTO.getAddress(), orderDate);
            return orderRepo.save(orderDetails);
        }else {
            throw new BookStoreException("This id is not present");
        }
    }


    public List<OrderDetails> display() {
        return orderRepo.findAll();

    }

    public String deleteById(int id) {
        Optional<OrderDetails> orderId = orderRepo.findById(id);
        if (orderId.isPresent()){
            orderRepo.deleteById(id);
            return "data Deleted by id successfully";
        }else {
            throw new BookStoreException("This id is not present");
        }
    }
}

