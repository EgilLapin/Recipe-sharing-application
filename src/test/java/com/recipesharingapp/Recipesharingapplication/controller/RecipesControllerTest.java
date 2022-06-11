package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.UserDTO;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
class RecipesControllerTest {

    @Autowired
    RecipesController recipesController;

    @Before
    public RecipesDTO createTestRecipeObject(){
        RecipesDTO testRecipeDTO = new RecipesDTO();;
        testRecipeDTO.setRecipeId(1L);
        testRecipeDTO.setRecipeName("TestBurger");
        return testRecipeDTO;
    }

    @Test
    void createRecipe() {
        RecipesDTO testRecipeDTO = createTestRecipeObject();
        ResponseEntity response = recipesController.createRecipe(testRecipeDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getById() {
        RecipesDTO testRecipeDTO = createTestRecipeObject();
        recipesController.createRecipe(testRecipeDTO);
        ResponseEntity response = recipesController.getById(2L);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}