Feature: Order billing computation
	To allow a customer to order some dishes.

	Scenario: Order some dishes an compute the order amount
		Given the menu contains the following dishes
			| name        | price |
			| gyoza       | 8.0   |
			| okonomiyaki | 17.0  |
			| yakisoba    | 11.50 |
			| kimchi      | 4.0   |
			| sukiyaki    | 10.25 |
		And the customer ordered 2 "gyoza"
		And  the customer ordered 3 "kimchi"
		And  the customer ordered 1 "okonomiyaki"
		And  the customer ordered 2 "sukiyaki"
		When the waiter computes the bill
		Then the bill amount should be "65.50"
