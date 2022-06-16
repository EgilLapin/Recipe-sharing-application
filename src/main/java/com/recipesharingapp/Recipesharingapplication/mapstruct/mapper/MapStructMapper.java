package com.recipesharingapp.Recipesharingapplication.mapstruct.mapper;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface  MapStructMapper {

    RecipesDTO recipesToRecipesDTO(Recipes recipes);
    Recipes recipesDTOToRecipes(RecipesDTO recipesDTO);

}
