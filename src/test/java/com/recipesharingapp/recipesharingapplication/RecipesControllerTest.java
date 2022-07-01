package com.recipesharingapp.recipesharingapplication;

import com.recipesharingapp.recipesharingapplication.controller.RecipesController;
import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.recipesharingapplication.service.RecipesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipesControllerTest {

    @Autowired
    RecipesController recipesController;

    @Mock
    RecipesService service;

    @Test
    void createRecipeTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Recipes testRecipe = new Recipes();
        testRecipe.setRecipeId(1L);
        testRecipe.setRecipeName("TestBurger");
        testRecipe.setUser("TestUser");
        when(service.createRecipe(any(Recipes.class))).thenReturn(testRecipe);
        BindingResult bindingResult = mock(BindingResult.class);
        ResponseEntity<Recipes> responseEntity = recipesController.createRecipe(testRecipe,bindingResult);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());

    }

    @Test
    void createInvalidRecipeTest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Recipes testRecipe = new Recipes();
        testRecipe.setRecipeId(1L);
        testRecipe.setRecipeName(null);
        testRecipe.setUser(null);
        when(service.createRecipe(any(Recipes.class))).thenReturn(testRecipe);
        BindingResult bindingResult = mock(BindingResult.class);
        Mockito.when(bindingResult.hasErrors()).thenReturn(true);
        ResponseEntity<Recipes> responseEntity = recipesController.createRecipe(testRecipe,bindingResult);
        assertThat(responseEntity.getStatusCode().is4xxClientError());
    }

    @Test
    void findRecipesById() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Recipes testRecipe = new Recipes();
        testRecipe.setRecipeId(1L);
        testRecipe.setRecipeName("TestBurger");
        testRecipe.setUser("TestUser");
        when(service.findRecipesById(1L)).thenReturn(Optional.of(testRecipe));
        ResponseEntity<Recipes> responseEntity = recipesController.findRecipesById(1L);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }

    @Test
    void findInvalidRecipesById() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        when(service.findRecipesById(1L)).thenReturn(null);
        ResponseEntity<Recipes> responseEntity = recipesController.findRecipesById(1L);
        assertThat(responseEntity.getStatusCode().is4xxClientError());
    }
}