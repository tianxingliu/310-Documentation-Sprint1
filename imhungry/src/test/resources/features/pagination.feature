Feature: Pagination of Results

Background:

	Given I visit the website
	
Scenario: "Next Page" button found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	Then I should see the "Next Page" button

Scenario: Page number found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	Then I should see the page number
	
Scenario: "Next Page" button is working
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press "Next Page" button
	Then I should go to the next page
	
Scenario: "Previous Page" button found
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press "Next Page" recipe
	Then I should see the "Previous Page" button
	
Scenario: "Previous Page" button is working
	When I search for "chicken" and expect 5 results
	And press "submit" button
	And press "Next Page" recipe
	And press "Previous Page" recipe
	Then I should go back to the Previous Page