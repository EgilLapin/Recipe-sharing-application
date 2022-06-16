package com.recipesharingapp.Recipesharingapplication.service;


import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
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
        Optional<Recipes> recipefound = recipesRepository.findById(id)
                .flatMap(recipes -> Optional.ofNullable(mapstructMapper.recipesDTOToRecipes(recipes)));
        return recipefound;
    }

}
