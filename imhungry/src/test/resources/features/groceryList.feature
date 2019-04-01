Feature: Grocery List

Background:

	Given I visit the website
	
Scenario: "Add to grocery" button found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press a recipe
	Then I should see the "Add to Grocery" button
	
Scenario: "Add to grocery" button found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	Then I should see the "Display Grocery" button

Scenario: Display functionality worked
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And I press "Display Grocery" bnutton
	Then I will go to the Grocery Page                                                                                                  

Scenario: Item addition functionality worked
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press a recipe
	And I press "Add to grocery" button
	And press "Back to Results" button
	And press "Display Grocery" button
	Then the item will be added to the grocery list