package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
import com.recipesharingapp.Recipesharingapplication.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RecipesController {

    @Autowired
    private RecipesService recipesService;
    @Autowired
    private MapStructMapper mapstructMapper;

    @PostMapping("/recipes")
    public ResponseEntity<Recipes> createRecipe(
            @RequestBody Recipes recipes, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
      Recipes recipeSaved = recipesService.createRecipe(recipes);
        return new ResponseEntity<>(recipeSaved, HttpStatus.CREATED);
    }


   @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipes> findRecipesById (
            @PathVariable(value = "id") Long id
    ) {

       Optional<Recipes> recipe = (recipesService.findRecipesById(id));
       if(!recipe.isPresent()){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(recipe.get());
    }


}
