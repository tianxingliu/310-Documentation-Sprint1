Feature: Grocery List

Background:

	Given I visit the website

Scenario: webpage load pre-defined list
	Then I should have the grocery list loaded
	
Scenario: "Add to grocery" button found
	When I am in the recipe page
	Then the "Add to grocery" button should be placed

Scenario: Item addition functionality worked
	When I am in the recipe page
	And I clicked the "Add to grocery" button
	Then the ingredients in the page will be added to the grocery list



