Feature: List Management Page

Background:

	Given I visit the website


Scenario: Radius input field exists
	Then the radius input field exists

Scenario: Radius input field default 2000
	Then the radis input field should have default value 2000
	
Scenario: Edited Radius will affect search query
	When I search for "sushi" and expect 5 results
	And change radius to 10000
	Then the radius that would be executed on will be 10000