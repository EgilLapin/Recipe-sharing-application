package com.recipesharingapp.Recipesharingapplication.entity;

import javax.persistence.*;

@Entity
public class Comment {
    //(id, user (who made the comment), recipe (where the comment is from), commentText)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipes recipe;
    private String commentText;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipes getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipes recipe) {
        this.recipe = recipe;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Comment(Long commentId, User user, Recipes recipe, String commentText) {
        this.commentId = commentId;
        this.user = user;
        this.recipe = recipe;
        this.commentText = commentText;
    }

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", user=" + user +
                ", recipe=" + recipe +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
