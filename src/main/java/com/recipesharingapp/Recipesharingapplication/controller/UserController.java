package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.UserDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(
            @RequestBody UserDTO userDto
    ) {
        userRepository.save(
                mapstructMapper.userDTOToUser(userDto)
        );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getById(
            @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(
                mapstructMapper.userToUserDTO(
                        userRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

}
