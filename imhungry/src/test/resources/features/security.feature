Feature: Security
#Backlog 1
Background:

	Given I visit the website and database is empty

Scenario: the software prevents SQL injection

	When I search for "', 0, 0); INSERT INTO GroceryList(GroceryItem) VALUES('test'); INSERT INTO Searches(Query, ResultsNum, Radius) VALUES('" and expect 5 results
    And press "submit" button
    And I press "Display Grocery" bnutton
	Then I should not see a grocery item #TODO
