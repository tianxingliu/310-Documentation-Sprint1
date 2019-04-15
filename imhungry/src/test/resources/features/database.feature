Feature: Grocery List

Background:

	Given I visit the website
	
Scenario: Data perserved after clearing the session
	When restart session
	And reload the page
	Then the data still preserves