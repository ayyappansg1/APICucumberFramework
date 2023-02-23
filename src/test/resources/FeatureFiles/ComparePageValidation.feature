Feature: This is to Validate Compare Menu

Background:
Given that user launching the "app_url" environment
And the user click on login Button and navigates to the Login Page
And the user pass "username" and "password" from property file and click login Button

@first
Scenario:  This scenario is to Validate order of Table headers after selecting PortFolios
Given that user is on HomePage and Click Compare Menu
And the user Select Portfolios from the Selectable Dropdown as mentioned Below
|Crypto|Renewable Energy|Biotech|
And the user click on View Result Button
When the user click and expand the Performance Chart
Then the user should see the Chart Labels as per Selected Order
When the user click and expand the Statistics Menu
Then the user should see Table headers of "Statistics" should be in the order of Portfolios Selected
When the user click and expand the Parameters Menu
Then the user should see Table headers of "Parameters" should be in the order of Portfolios Selected
When the user click and expand the ESG Menu
Then the user should see Table headers of "ESG" should be in the order of Portfolios Selected
When the user click and expand the Universe Menu
Then the user should see Table headers of "Universe" should be in the order of Portfolios Selected

 Scenario:  This scenario is to Validate order of Table headers after selecting PortFolios
Given that user is on HomePage and Click Compare Menu
And the user Select Portfolios from the Selectable Dropdown as mentioned Below
|	Crypto	|	Renewable Energy	|	Biotech	|
And the user click on View Result Button
Then the user should see 5 accordance as mentioned Below
|	Performance Chart	|	Statistics	|	Parameters	|ESG	|	Universe|
When the user click and expand the Statistics Menu
Then the user should see Table should have more than "2" Rows 
When the user click and expand the Parameters Menu
Then the user should see Table should have more than "2" Rows 
When the user click and expand the ESG Menu
Then the user should see Table should have more than "2" Rows 
When the user click and expand the Universe Menu
Then the user should see Table should have more than "2" Rows 