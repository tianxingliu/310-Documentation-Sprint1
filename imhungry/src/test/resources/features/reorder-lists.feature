Feature: Quick Access List

Background:

	Given I visit the website
	
Scenario: "Sort by Rating" button found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press "Manage List" button
	Then I should see "Sort by Rating" button

Scenario: "Sort by Rating" button worked
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press a recipe
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And press the second recipe #add step definition here
	And select the list "Favorites"
	And press "addtolist" button
	And press "backtoresults" button
	And press "Manage List" button
	And press "Sort by Rating" button 
	And the items will be sorted




