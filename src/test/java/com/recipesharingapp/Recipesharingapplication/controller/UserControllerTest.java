package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.UserDTO;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @Test
    public void createUser() {
        UserDTO testUserDTO = new UserDTO();;
        testUserDTO.setUserId(1L);
        testUserDTO.setUserName("EgilsTest");
        ResponseEntity response = userController.createUser(testUserDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        userRepository.deleteAll();
    }

    @Test
    public void getById() {
        User testUser = new User();;
        testUser.setUserId(1L);
        testUser.setUserName("EgilsTest2");
        userRepository.save(testUser);
        ResponseEntity response = userController.getById(1L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        userRepository.deleteAll();
    }
}