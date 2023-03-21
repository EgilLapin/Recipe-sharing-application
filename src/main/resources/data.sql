CREATE TABLE RecipesTable (
    recipeId bigserial not null
    primary key,
    recipeName text not null,
    user text not null
);


INSERT INTO RecipesTable (recipeId, recipeName, user) VALUES (1,'burger', 'User1');
INSERT INTO RecipesTable (recipeId, recipeName, user) VALUES (2, 'pizza', 'User2');
INSERT INTO RecipesTable (recipeId, recipeName, user) VALUES (3, 'soup', 'User3');
INSERT INTO RecipesTable (recipeId, recipeName, user) VALUES (4, 'sushi', 'User4');
INSERT INTO RecipesTable (recipeId, recipeName, user) VALUES (5, 'pasta', 'User5');
