package com.recipesharingapp.Recipesharingapplication.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class RecipesDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonProperty("recipeId")
        private Long recipeId;
        @JsonProperty("recipeName")
        private String recipeName;
        @JsonProperty("user")
        private String user;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}


