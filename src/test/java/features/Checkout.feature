Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search Experiance for product search in both home and offer page

Given User is on Green kart Landing Page
When User searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then user proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
|Name|
|Tom|

