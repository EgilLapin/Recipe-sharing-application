package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.UserDTO;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    UserController userController;

    @Before
    public UserDTO createTestUser(){
        UserDTO testUserDTO = new UserDTO();;
        testUserDTO.setUserId(1L);
        testUserDTO.setUserName("EgilsTest");
        return testUserDTO;
    }

    @Test
    void createUser() {
        UserDTO testUserDTO = createTestUser();
        ResponseEntity response = userController.createUser(testUserDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getById() {
        UserDTO testUserDTO = createTestUser();
        userController.createUser(testUserDTO);
        ResponseEntity response = userController.getById(1L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}