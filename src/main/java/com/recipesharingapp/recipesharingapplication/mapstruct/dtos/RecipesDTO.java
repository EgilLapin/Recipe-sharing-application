package com.recipesharingapp.recipesharingapplication.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class RecipesDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty("recipeId")
        private Long recipeId;
        @JsonProperty("recipeName")
        private String recipeName;
        @JsonProperty("user")
        private String user;

    public Long getRecipeId() {
        return recipeId;
    }

}


