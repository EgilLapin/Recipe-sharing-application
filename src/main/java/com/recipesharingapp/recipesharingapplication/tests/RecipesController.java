package com.recipesharingapp.recipesharingapplication.tests;

import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.recipesharingapplication.service.RecipesService;
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
            @RequestBody Recipes recipes, BindingResult bindingResult) {

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
