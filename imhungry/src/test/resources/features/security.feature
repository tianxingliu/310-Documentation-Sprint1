Feature: Security
#Backlog 1
Background:

	Given I visit the website and database is empty

Scenario: the software prevents SQL injection

	When I search for "', 0, 0); INSERT INTO GroceryList(GroceryItem) VALUES('test'); INSERT INTO Searches(Query, ResultsNum, Radius) VALUES('" and expect 5 results
    And press "submit" button
    And I press "Display Grocery" bnutton
	Then I should not see a grocery item #TODO


Scenario: user login button exists
	Then I should see a "login" button

Scenario: user login button worked
	When I clicked on the "login" button
	Then I will be directed to the login-page

Scenario: login page error message displaced
	When I clicked on the "login" button
	And click "log-in"
	Then error message will show-up

Scenario: user login funtionality worked
	When I clicked on the "login" button
	And input a user-id and password
	Then I will be directed back to the search page
	And the user profile will be placed at top

	