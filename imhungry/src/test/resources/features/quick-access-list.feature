Feature: Quick Access List

Background:

	Given I visit the website
	
Scenario: "Quick Access List" found
	Then I should see the "Quick Access List"

Scenario: "Quick Access List" go to Search Page
	When press "Quick Access List" button
	And press a previous search terms
	Then I should go to the Search Page

Scenario: Search terms added to "Quick Access List"
	When I search for "pizza" and expect 5 results
	And press "submit" button
	And press "Back to Search" button
	Then I should see "pizza" in the "Quick Access List"