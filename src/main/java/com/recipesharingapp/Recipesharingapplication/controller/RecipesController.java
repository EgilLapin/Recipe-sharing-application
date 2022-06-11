package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipesController {

    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    @PostMapping("/recipes")
    public ResponseEntity<Void> createRecipe(
            @RequestBody RecipesDTO recipesDTO
    ) {

        recipesRepository.save(
                mapstructMapper.recipesDTOToRecipes(recipesDTO)
        );


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
