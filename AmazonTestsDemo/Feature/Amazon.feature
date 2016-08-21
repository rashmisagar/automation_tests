Feature: Search, Add and Edit item on Amazon
 	As an Amazon user, when I add an item to the basket, I am able to see the item details in the basket
 
Scenario: Open Amazon Page
	Given Browser is open
	When User Navigates to Amazon Page
	Then Amazon Page is open
	
Scenario: Search book
	Given Amazon Page is open
	When I navigate to books section
	And I enter "Game of Thrones" in the Search field
  	Then The search results are shown
  	And first item has the title "A Game of Thrones (A Song of Ice and Fire, Book 1)"
	And badge is "#1 Best Seller"
	And Selected type is "Paperback"
  	And price is "£4.00"

Scenario: Verify book details of Game of Thrones
	Given first item has the title "A Game of Thrones (A Song of Ice and Fire, Book 1)"
	When I navigate to the book details
	Then title is shown as "A Game of Thrones (A Song of Ice and Fire, Book 1)"
  	And badge is "Best Seller"
	And price is "£4.00"
	And type is "Paperback" 
	
Scenario: Add book to the basket
	Given title is shown as "A Game of Thrones (A Song of Ice and Fire, Book 1)"
	And Add button is shown
	When I Add the book to the basket
	Then Notification is shown
  	And the title is Added to Basket
  	And quantity is "1"
	
Scenario: Edit the basket
	Given the title is Added to Basket
	When I Click on edit the basket
  	Then "A Game of Thrones (A Song of Ice and Fire, Book 1)" is shown on the list
	And title is shown as "A Game of Thrones (A Song of Ice and Fire, Book 1)" 
	And type is "Paperback"
	And price is "£4.00" 
	And quantity is "1"
	And total price is "Subtotal (1 item): £4.00"

