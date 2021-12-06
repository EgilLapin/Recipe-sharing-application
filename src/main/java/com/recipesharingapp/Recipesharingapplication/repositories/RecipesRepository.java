package com.recipesharingapp.Recipesharingapplication.repositories;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import com.recipesharingapp.Recipesharingapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes,Long> {

    @Query("select x.recipeName from Recipes x where x.userId = ?1")
    List<Recipes> getRecipesByUser(Long userId);

}
