package com.example.bookstore.service;

import com.example.bookstore.dto.UserDTO;

public interface IUserInterface {
    Object saveAll(UserDTO userDTO);

    Object display();

    Object findById(int id);

    Object update(UserDTO userDTO, int id);

    Object deleteById(int id);
}
