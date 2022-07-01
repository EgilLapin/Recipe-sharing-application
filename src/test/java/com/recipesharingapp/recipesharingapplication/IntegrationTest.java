package com.recipesharingapp.recipesharingapplication;


import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.recipesharingapplication.repositories.RecipesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RecipesRepository repository;


    @Test
    void findRecipesByIdIntegrationTest(){
        RecipesDTO testRecipe = new RecipesDTO();
        testRecipe.setRecipeId(1L);
        testRecipe.setRecipeName("TestBurger1");
        testRecipe.setUser("TestUser1");
        repository.save(testRecipe);
        ResponseEntity<Recipes> response = testRestTemplate.getForEntity("/recipes/1", Recipes.class);
        assertEquals(1, response.getBody().getRecipeId());
        assertEquals("TestBurger1", response.getBody().getRecipeName());
        assertEquals("TestUser1", response.getBody().getUser());
    }

    @Test
    void findInvalidRecipesByIdIntegrationTest(){
        ResponseEntity<Recipes> response = testRestTemplate.getForEntity("/recipes/666", Recipes.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void createRecipeIntegrationTest(){
        Recipes recipes = new Recipes();
        recipes.setRecipeName("TestBurger2");
        recipes.setUser("TestUser2");

        HttpEntity<Recipes> request = new HttpEntity<>(recipes);
        ResponseEntity<Recipes> response = testRestTemplate.postForEntity("/recipes",request,Recipes.class);

        assertNotNull(response.getBody().getRecipeId());
        assertEquals("TestBurger2", response.getBody().getRecipeName());
        assertEquals("TestUser2", response.getBody().getUser());
    }

    @Test
    void createInvalidRecipeNameIntegrationTest(){
        Recipes recipes = new Recipes();
        recipes.setRecipeName(null);
        HttpEntity<Recipes> request = new HttpEntity<>(recipes);
        ResponseEntity<Recipes> response = testRestTemplate.postForEntity("/recipes",request,Recipes.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void createInvalidRecipeUserNameIntegrationTest(){
        Recipes recipes = new Recipes();
        recipes.setUser(null);
        HttpEntity<Recipes> request = new HttpEntity<>(recipes);
        ResponseEntity<Recipes> response = testRestTemplate.postForEntity("/recipes",request,Recipes.class);
        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
