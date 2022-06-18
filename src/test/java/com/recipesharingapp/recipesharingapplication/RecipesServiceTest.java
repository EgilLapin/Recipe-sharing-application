package com.recipesharingapp.recipesharingapplication;

import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.recipesharingapplication.repositories.RecipesRepository;
import com.recipesharingapp.recipesharingapplication.service.RecipesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipesServiceTest {

    @InjectMocks
    RecipesService recipesService;

    @Mock
    MapStructMapper mapStructMapper;

    @Mock
    RecipesRepository repository;

    @Test
    void createRecipeTest() {
        Recipes testRecipe = new Recipes(1L,"TestBurger","TestUser");
        when(repository.save(mapStructMapper.recipesToRecipesDTO(testRecipe))).thenReturn(new RecipesDTO());
        recipesService.createRecipe(testRecipe);
        verify(repository,times(1))
                .save(mapStructMapper.recipesToRecipesDTO(testRecipe));
    }

    @Test
    void findRecipesById() {
        RecipesDTO testRecipe = new RecipesDTO();
        testRecipe.setRecipeId(1L);
        testRecipe.setRecipeName("TestBurger");
        testRecipe.setUser("TestUser");
        when(repository.findById(anyLong())).thenReturn(Optional.of(testRecipe));

        recipesService.findRecipesById(testRecipe.getRecipeId());

        verify(repository,times(1)).findById(anyLong());
    }

}