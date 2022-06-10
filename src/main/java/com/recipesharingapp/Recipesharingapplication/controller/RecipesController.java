package com.recipesharingapp.Recipesharingapplication.controller;

import com.recipesharingapp.Recipesharingapplication.mapstruct.dtos.RecipesDTO;
import com.recipesharingapp.Recipesharingapplication.mapstruct.mapper.MapStructMapper;
import com.recipesharingapp.Recipesharingapplication.repositories.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipesController {

    @Autowired
    private RecipesRepository recipesRepository;
    @Autowired
    private MapStructMapper mapstructMapper;

    @PostMapping("/recipes")
    public ResponseEntity<Void> createUser(
            @RequestBody RecipesDTO recipesDTO
    ) {

        recipesRepository.save(
                mapstructMapper.recipesDTOToRecipes(recipesDTO)
        );


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<RecipesDTO> getById(
            @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(
                mapstructMapper.recipesToRecipesDTO(
                        recipesRepository.findById(id).get()
                ),
                HttpStatus.OK
        );
    }

}
