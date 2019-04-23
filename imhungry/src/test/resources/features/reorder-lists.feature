Feature: Quick Access List

Background:

	Given I visit the website and database is empty
	
Scenario: "Move up" button found
	
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press "Manage List" button
	Then I should see "Move up" button
	
Scenario: "Move down" button found
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press "Manage List" button
	Then I should see "Move down" button

Scenario: "Move up" button worked
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press a recipe
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And press the second recipe
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And select the list "Favorites"
	And press "Manage List" button
	And press "↑" button 
	Then the items will be ordered
	
Scenario: "Move down" button worked
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press a recipe
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And press the second recipe
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And select the list "Favorites"
	And press "Manage List" button
	And press "Move down" button 
	Then the items will be ordered




