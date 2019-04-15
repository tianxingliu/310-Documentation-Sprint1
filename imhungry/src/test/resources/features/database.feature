Feature: Database
#Backlog 2
Background:

	Given I visit the website and database is empty

Scenario: maintain information beyond just a single session

	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press a restaurant
	And select the list "Favorites"
	And press "Add to List" button
	And restart session
	And I search for "chicken" and expect 5 results
	And select the list "Favorites"
	And press "Manage List" button
	Then I should see an info item


	
Scenario: Data perserved after clearing the session
	When restart session
	And reload the page
	Then the data still preserves
