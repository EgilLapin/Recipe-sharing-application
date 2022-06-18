package com.recipesharingapp.recipesharingapplication;

import com.recipesharingapp.recipesharingapplication.repositories.RecipesRepository;
import com.recipesharingapp.recipesharingapplication.service.RecipesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipesServiceTest {

    @Autowired
    RecipesService recipesService;

    @Mock
    RecipesRepository repository;

    @Test
    void createRecipeTest() {
    }

    @Test
    void createInvalidRecipeTest() {
    }

    @Test
    void findRecipesById() {
    }

    @Test
    void findInvalidRecipesById() {
    }
}