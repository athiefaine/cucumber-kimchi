Feature: Order billing computation
	To allow a customer to order some dishes and compute his/her bill.

	Background:
		Given the menu contains the following dishes
			| name        | price |
			| gyoza       | 8.0   |
			| okonomiyaki | 17.0  |
			| yakisoba    | 11.50 |
			| kimchi      | 4.0   |
			| sukiyaki    | 10.25 |

	Scenario: Order some dishes
		Given the customer ordered 2 "gyoza"
		And  the customer ordered 3 "kimchi"
		And  the customer ordered 1 "okonomiyaki"
		And  the customer ordered 2 "sukiyaki"
		When the waiter computes the bill
		Then the bill amount should be "65.50"

	Scenario: Order a single dish
		Given the customer ordered 1 "okonomiyaki"
		When the waiter computes the bill
		Then the bill amount should be "17.00"

	Scenario: Order more than 10 dishes, get 10% voucher
		Given the customer ordered 2 "gyoza"
		And  the customer ordered 3 "kimchi"
		And  the customer ordered 1 "okonomiyaki"
		And  the customer ordered 2 "sukiyaki"
		And  the customer ordered 3 "yakisoba"
		When the waiter computes the bill
		Then the bill amount should be "90.00"

	Scenario: Order 3 gyoza, one is offered
		Given the customer ordered 3 "gyoza"
		And  the customer ordered 3 "kimchi"
		And  the customer ordered 1 "okonomiyaki"
		And  the customer ordered 2 "sukiyaki"
		When the waiter computes the bill
		Then the bill amount should be "65.50"

