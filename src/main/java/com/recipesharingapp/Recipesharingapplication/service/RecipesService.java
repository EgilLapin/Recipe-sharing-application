package com.recipesharingapp.Recipesharingapplication.service;


import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
import com.recipesharingapp.Recipesharingapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesService {
    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private UserRepository userRepository;

    public Recipes createRecipe(Recipes recipes) {
        return recipesRepository.save(recipes);
    }

    public List<Recipes> getRecipeList() {
        return recipesRepository.findAll();
    }

    public Recipes getRecipebyId(Long recipeId) {
        return recipesRepository.findById(recipeId).get();
    }

    public Recipes updateRecipeById(Long recipeId, Recipes recipes) {
        Recipes recipeDB = recipesRepository.findById(recipeId).get();
        recipeDB.setRecipeName(recipes.getRecipeName());
        recipeDB.setUser(recipes.getUser());
        return recipesRepository.save(recipeDB);
    }

    public void deleteRecipeById(Long recipeId) {
        recipesRepository.deleteById(recipeId);
    }

}
