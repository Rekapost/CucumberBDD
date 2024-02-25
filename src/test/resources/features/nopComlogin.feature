#Author : name@gmail.com
#Keywords Summary:
#Feature: List of scenarios
#Scenario : business rule through list of steps with arguments
# given : some precondition step
#when :some key actions 
#Then : to observe outcomes or validations
# and , but: to enumerate more Given ,When,Then steps
# scenario outline : list of steps for data -driven as an examples and < placeholder>
# examples : container for s table 
# background : list of steps run before each  of the scenarios 
# """ (Doc strings)
#| data tables
#@ (tags/labels)to group scenarios
#<> placeholder
#""
## comments
#@tag1
#sample feature definition template
@login
Feature: nopCommerce login

Background: below are the common steps for each scenario
  Given  open browser 

@sanity
Scenario: login to nopcommece using user id and password
  When   open nopcommerce link "https://admin-demo.nopcommerce.com"
  Then   enter user id "admin@yourstore.com" and password "admin"
  Then   dashboard page opens 
  And    click logout
  And    come to home page 
  
@regression
Scenario Outline: Login to nopCommerce with valid parameters
  Given Launch Chrome browser
  When open nopcommerce link for DDT "https://admin-demo.nopcommerce.com"
  And  Enter username "<userName>" and password "<passWord>"
  And  Click on login button
  Then User must be successfully able to login to dashboard page
  
    Examples:
      | userName            | passWord |
      | adm@yourstore.com   | admin123 |
      | admin@yourso.com    | adminxyz |
      | admin@yourstore.com | admin&*  |
      | admin@yourstore.com | admin    | 
      
      
      