package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.service.RecipesService;
import com.recipesharingapp.Recipesharingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Create recipe
//- Get recipe by id
//- Update recipe by id
//- Delete recipe by id
//- Get all recipes made by user by userId
@RestController
public class RecipesController {

    @Autowired
    private RecipesService recipesService;
    @Autowired
    private UserService userService;

    // Create recipe
    @PostMapping("/recipes")
    public Recipes createUser(@RequestBody Recipes recipes){
        return recipesService.createRecipe(recipes);
    }

    //- Get recipe by id
    @GetMapping("/recipes/{id}")
    public Recipes getRecipe(@PathVariable("id") Long recipeId){
        return recipesService.getRecipebyId(recipeId);
    }

    //Get all receipes
    @GetMapping("/recipes")
    public List<Recipes> getRecipeList(){
        return recipesService.getRecipeList();
    }

    //- Delete recipe by id
    @DeleteMapping("recipes/{id}")
    public String deleteRecipeById(@PathVariable("id") Long recipeId){
        recipesService.deleteRecipeById(recipeId);
        return "Recipe Deleted!";
    }
}
