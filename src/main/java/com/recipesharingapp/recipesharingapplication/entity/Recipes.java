package com.recipesharingapp.recipesharingapplication.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    @NotNull
    private String recipeName;
    @NotNull
    private String userName;

}
