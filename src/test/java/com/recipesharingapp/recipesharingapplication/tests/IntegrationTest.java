package com.recipesharingapp.recipesharingapplication.tests;


import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @Sql("/test.sql")
    void findRecipesByIdIntegrationTest(){
        ResponseEntity<Recipes> response = testRestTemplate.getForEntity("/recipes/1", Recipes.class);
        assertEquals(1, response.getBody().getRecipeId());
        assertEquals("TestBurger1", response.getBody().getRecipeName());
        assertEquals("TestUser1", response.getBody().getUser());
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
}
