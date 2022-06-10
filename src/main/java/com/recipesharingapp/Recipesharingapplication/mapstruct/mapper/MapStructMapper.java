package com.recipesharingapp.Recipesharingapplication.mapstruct.mapper;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.UserDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface  MapStructMapper {

    RecipesDTO recipesToRecipesDTO(Recipes recipes);
    UserDTO userToUserDTO(User user);
    Recipes recipesDTOToRecipes(RecipesDTO recipesDTO);
    User userDTOToUser(UserDTO userDTO);

}
