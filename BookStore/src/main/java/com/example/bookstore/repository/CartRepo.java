package com.example.bookstore.repository;

import com.example.bookstore.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface CartRepo extends JpaRepository<CartDetails, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update bookstore.cart_details set quantity = :bookQuantity, total_Book_Price = :totalBookPrice where id = :cartId", nativeQuery = true)
    void updateCartByQuantity(int cartId, int bookQuantity, double totalBookPrice);

}
