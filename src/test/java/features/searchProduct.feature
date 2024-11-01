Feature: Search and Place the order for Products

@offersPage
Scenario Outline: Search Experiance for product search in both home and offer page

Given User is on Green kart Landing Page
When User searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> shortname in offers page 
And validate product name in offers page matches with Landing page

Examples:
|Name|
|Tom|
|Beet|

 
