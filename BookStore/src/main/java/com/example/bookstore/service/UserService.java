package com.example.bookstore.service;

import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.exceptionalHandler.BookStoreException;
import com.example.bookstore.model.UserDetails;
import com.example.bookstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserInterface {

    @Autowired
    UserRepo userRepo;

    public UserDetails saveAll(UserDTO userDTO){
        List<UserDetails> userDetails = userRepo.findAll();
        for(UserDetails userData : userDetails){
            if(userData.getUserName().equals(userDTO.getUserName())){
                throw new BookStoreException("This is duplicate value");
            }
        }
        UserDetails userDetails1 = new UserDetails(userDTO);
        return userRepo.save(userDetails1);
    }
    public List<UserDetails> display(){
        return userRepo.findAll();
    }
    public UserDetails findById(int id) {
        return userRepo.findById(id).orElseThrow(() ->
                new BookStoreException("Employee with id " +id+ " does not exist in database"));
    }
    public UserDetails update(UserDTO userDTO, int id){
        if(userRepo.findById(id).isPresent()) {
            List<UserDetails> userDetails = userRepo.findAll();
            for(UserDetails userData : userDetails) {
                if (userData.getId() != id && userData.getUserName().equals(userDTO.getUserName())) {
                    throw new BookStoreException("this is duplicate value");
                }
            }
            UserDetails userDetails1 = new UserDetails(userDTO, id);
            return userRepo.save(userDetails1);
        } else {
            throw (new BookStoreException("This id is not present"));
        }
    }
    public String deleteById(int id) {
        Optional<UserDetails> userId = userRepo.findById(id);
        if(userId.isPresent()) {
            userRepo.deleteById(id);
            return  "data deleted by id successfully";
        } else {
            throw (new BookStoreException("This id is not present"));
        }
    }

}
