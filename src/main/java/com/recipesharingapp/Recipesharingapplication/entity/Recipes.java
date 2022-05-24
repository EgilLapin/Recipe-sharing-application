package com.recipesharingapp.Recipesharingapplication.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Recipes {
    //id, name, recipeText, user (who made the recipe), list of comments
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;
    private String recipeName;
    @ManyToOne
    @JoinColumn(name = "userId")
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


    public Recipes(Long recipeId, String recipeName, User user) {
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
