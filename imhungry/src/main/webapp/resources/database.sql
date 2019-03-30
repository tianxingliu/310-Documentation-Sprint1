DROP DATABASE IF EXISTS ImHungryDatabase;
CREATE DATABASE ImHungryDatabase;
USE ImHungryDatabase;
             
CREATE TABLE Restaurants (
    RestaurantKeyID INT(11) PRIMARY KEY AUTO_INCREMENT,
    RestaurantName VARCHAR(200) NOT NULL,
    RestaurantRating INT(11) NOT NULL,
    PlaceID VARCHAR(200) NOT NULL,
    Address VARCHAR(200) NOT NULL,
    Price INT(11) NOT NULL,  -- note that the constructor takes an integer for price level
    DriveTimeText VARCHAR(200) NOT NULL,
    DriveTimeValue INT(11) NOT NULL,
    Phone VARCHAR(200) NOT NULL,
    Website VARCHAR(200) NOT NULL,
    RestaurantInList VARCHAR(20) NOT NULL
);

CREATE TABLE Recipes(
    RecipeKeyID INT(11) PRIMARY KEY AUTO_INCREMENT,
    RecipeName VARCHAR(200) NOT NULL,
    RecipeRating INT(11) NOT NULL,
    RecipeID INT(11) NOT NULL,
    PrepTime INT(11) NOT NULL,
    CookTime INT(11) NOT NULL,
    Ingredients VARCHAR(500) NOT NULL,
    Instructions VARCHAR(1000) NOT NULL,
    ImageURL VARCHAR(500) NOT NULL,
    RecipeInList VARCHAR(20) NOT NULL
);

CREATE TABLE GroceryList(
    GroceryID INT(11) PRIMARY KEY AUTO_INCREMENT,
    GroceryItem VARCHAR(200) NOT NULL
);