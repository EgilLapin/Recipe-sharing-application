package com.recipesharingapp.recipesharingapplication.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    @NotNull
    private String recipeName;
    @NotNull
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


    public Recipes(Long recipeId, String recipeName, String user) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.user = user;
    }

    public Recipes() {
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", user=" + user +
                '}';
    }
}
