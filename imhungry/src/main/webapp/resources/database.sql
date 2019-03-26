DROP DATABASE IF EXISTS ImHungryDatabase;
CREATE DATABASE ImHungryDatabase;
USE ImHungryDatabase;
             
CREATE TABLE Restaurants (
    restaurantKeyID INT(11) PRIMARY KEY AUTO_INCREMENT,
    restaurantName VARCHAR(200) NOT NULL,
    restaurantRating INT(11) NOT NULL,
    placeID VARCHAR(200) NOT NULL,
    address VARCHAR(200) NOT NULL,
    price INT(11) NOT NULL,  -- note that the constructor takes an integer for price level
    driveTimeText VARCHAR(200) NOT NULL,
    driveTimeValue INT(11) NOT NULL,
    phone VARCHAR(200) NOT NULL,
    website VARCHAR(200) NOT NULL,
    restaurantInList VARCHAR(20) NOT NULL  -- 'favorite', 'toexplore', 'donotshow'
);

CREATE TABLE Recipes(
    recipeKeyID INT(11) PRIMARY KEY AUTO_INCREMENT,
    recipetName VARCHAR(200) NOT NULL,
    recipeRating INT(11) NOT NULL,
    recipeID INT(11) NOT NULL,
    prepTime INT(11) NOT NULL,
    cookTime INT(11) NOT NULL,
    imageURL VARCHAR(500) NOT NULL,
    recipeInList VARCHAR(20) NOT NULL  -- 'favorite', 'toexplore', 'donotshow'
);

CREATE TABLE Ingredients (
    ingredientID INT(11) PRIMARY KEY AUTO_INCREMENT,
    recipeKeyID INT(11) NOT NULL,  -- SELECT LAST_INSERT_ID();
    ingredient VARCHAR(200) NOT NULL,
    FOREIGN KEY (recipeKeyID) REFERENCES Recipes(recipeKeyID)
);

CREATE TABLE Instructions(
    instructionID INT(11) PRIMARY KEY AUTO_INCREMENT,
    recipeKeyID INT(11) NOT NULL,  -- SELECT LAST_INSERT_ID();
    instruction VARCHAR(200) NOT NULL,
    FOREIGN KEY (recipeKeyID) REFERENCES Recipes(recipeKeyID)
);

CREATE TABLE Grocery(
    groceryID INT(11) PRIMARY KEY AUTO_INCREMENT,
    groceryItem VARCHAR(200) NOT NULL
);