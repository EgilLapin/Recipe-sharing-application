package com.recipesharingapp.Recipesharingapplication.service;


import com.recipesharingapp.Recipesharingapplication.entity.Comment;
import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateUserById(Long commentId, Comment comment) {
        Comment commDB = commentRepository.findById(commentId).get();
        commDB.setCommentText(comment.getCommentText());
        return commentRepository.save(commDB);
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> findByUser_UserId(Long userId) {
        List<Comment> commentDB =  commentRepository.findByUser_UserId(userId).stream().toList();
        return commentDB;
    }

    public List<Comment> findByRecipe_RecipeId(Long recipeId) {
        List<Comment> commentDB =  commentRepository.findByRecipe_RecipeId(recipeId).stream().toList();
        return commentDB;
    }
}
