package com.recipesharingapp.recipesharingapplication.mapstruct.mapper;

import com.recipesharingapp.recipesharingapplication.entity.Recipes;
import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface  MapStructMapper {

    RecipesDTO recipesToRecipesDTO(Recipes recipes);
    Recipes recipesDTOToRecipes(RecipesDTO recipesDTO);

}
