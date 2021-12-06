package com.recipesharingapp.Recipesharingapplication.repositories;

import com.recipesharingapp.Recipesharingapplication.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

    Collection<Comment> findByUser_UserId(Long userId);

    Collection<Comment> findByRecipe_RecipeId(Long recipeId);
}
