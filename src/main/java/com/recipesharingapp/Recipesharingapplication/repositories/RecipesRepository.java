package com.recipesharingapp.Recipesharingapplication.repositories;

import com.recipesharingapp.Recipesharingapplication.entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes,Long> {

}
