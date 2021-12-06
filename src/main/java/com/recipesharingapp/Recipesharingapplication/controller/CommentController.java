package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.entity.Comment;
import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import com.recipesharingapp.Recipesharingapplication.service.CommentService;
import com.recipesharingapp.Recipesharingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//- Create comment
//- Update comment by id
//- Delete comment by id
//- Get all comments by recipe id
//- Get all comments by user id
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //- Create comment
    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }
    //- Update comment by id
    @PutMapping("/comments/{id}")
    public Comment updateCommentById(@PathVariable("id") Long commentId, @RequestBody Comment comment){
        return commentService.updateUserById(commentId, comment);
    }

    //- Delete comment by id
    @DeleteMapping("/comments/{id}")
    public String deleteCommentById(@PathVariable("id") Long commentId){
        commentService.deleteCommentById(commentId);
        return "User Deleted!";
    }

    //- Get all comments by user id
    @GetMapping("usercomments/{userId}")
    public List<Comment> findByUser_UserId(@PathVariable("userId") Long userId){
        return commentService.findByUser_UserId(userId);
    }
    //- Get all comments by recipe id
    @GetMapping("recipecomments/{recipeId}")
    public List<Comment> findByRecipe_RecipeId(@PathVariable("recipeId") Long recipeId){
        return commentService.findByRecipe_RecipeId(recipeId);
    }


}
