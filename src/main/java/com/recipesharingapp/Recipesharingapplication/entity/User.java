package com.recipesharingapp.Recipesharingapplication.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class User {
    //(id, name, list of recipes, list of comments)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long userId;
    private String userName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipeId")
    private List<Recipes> recipes;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commentId")
    private List<Comment> comment;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public User(Long userId, String userName, List<Recipes> recipes, List<Comment> comment) {
        this.userId = userId;
        this.userName = userName;
        this.recipes = recipes;
        this.comment = comment;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", recipes=" + recipes +
                ", comment=" + comment +
                '}';
    }
}
