package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
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

    @Test
    void createRecipe() {
        RecipesDTO testRecipeDTO = new RecipesDTO();;
        testRecipeDTO.setRecipeId(1L);
        testRecipeDTO.setRecipeName("TestBurger2");
        ResponseEntity response = recipesController.createRecipe(testRecipeDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}