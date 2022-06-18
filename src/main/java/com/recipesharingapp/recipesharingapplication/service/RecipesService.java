package com.recipesharingapp.recipesharingapplication.service;


import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.recipesharingapplication.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipesService {

    @Autowired
    RecipesRepository recipesRepository;
    @Autowired
    MapStructMapper mapstructMapper;

    public Recipes createRecipe(Recipes recipes) {
        RecipesDTO savedRecipeDTO = recipesRepository.save(
                mapstructMapper.recipesToRecipesDTO(recipes)
        );

        return mapstructMapper.recipesDTOToRecipes(savedRecipeDTO);
    }

    public Optional<Recipes> findRecipesById (Long id) {
        return recipesRepository.findById(id)
                .flatMap(recipes -> Optional.ofNullable(mapstructMapper.recipesDTOToRecipes(recipes)));
    }

}
