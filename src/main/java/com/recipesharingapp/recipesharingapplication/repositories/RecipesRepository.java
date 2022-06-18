package com.recipesharingapp.recipesharingapplication.repositories;

import com.recipesharingapp.recipesharingapplication.mapstruct.dtos.RecipesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<RecipesDTO,Long> {

}
