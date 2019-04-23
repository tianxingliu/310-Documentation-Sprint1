Feature: Database
#Backlog 2
Background:

	Given I visit the website and database is empty

Scenario: Predefined lists information beyond just a single session
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

Scenario: Grocery List information beyond just a single session
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press a recipe
	And press "Add to grocery" button
	And press "Back to Results" button
	And restart session
	And I search for "pizza" and expect 5 results
	And press "Display Grocery" button
	Then I should see the grocery list item

Scenario: Prior search term information beyond just a single session
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And restart session
	Then I should see the prior search term

Scenario: User specific information
	When I login as user A
	And I search for "pizza" and expect 5 results
	And press "submit" button
	And restart session
	And I login as user B
	Then I should not see the prior search term by user A
