CREATE TABLE RecipesTable (
    recipeId bigserial not null
    primary key,
    recipe_name text not null,
    user_name text not null
);


INSERT INTO RecipesTable (recipe_name, user_name) VALUES ('burger', 'User1');
INSERT INTO RecipesTable (recipe_name, user_name) VALUES ('pizza', 'User2');
INSERT INTO RecipesTable (recipe_name, user_name) VALUES ('sushi', 'User3');
