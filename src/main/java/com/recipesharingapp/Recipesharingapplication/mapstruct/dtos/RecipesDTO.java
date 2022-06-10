package com.recipesharingapp.Recipesharingapplication.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipesharingapp.Recipesharingapplication.entity.User;

public class RecipesDTO {
        @JsonProperty("recipeId")
        private Long recipeId;
        @JsonProperty("recipeName")
        private String recipeName;
        @JsonProperty("user")
        private User user;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


