package com.example.bookstore.controller;

import com.example.bookstore.dto.ResponseDTO;
import com.example.bookstore.dto.UserDTO;
import com.example.bookstore.service.IUserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
     IUserInterface iUserInterface;


    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@Valid  @RequestBody UserDTO userDTO){
        ResponseDTO responseDTO = new ResponseDTO("saved data successfully", iUserInterface.saveAll(userDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/userdata")
    public ResponseEntity<ResponseDTO> displayAll(){
        ResponseDTO responseDTO = new ResponseDTO("displayed all data successfully",iUserInterface.display());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Get call for Id successfully",iUserInterface.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody UserDTO userDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Updated data successfully", iUserInterface.update(userDTO, id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted id successfully", iUserInterface.deleteById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
