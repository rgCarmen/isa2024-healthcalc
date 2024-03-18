#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculate Ideal Weight
I want to calculate the ideal weight according to the parameters entered so that I can know the resulting ideal weight.


  @tag1
  Scenario Outline: Invalid Height
    Given I have an health calculator
    When I compute the ideal weight for negative height <h>
    Then the system raise an exception
    
   	Examples: 
      | h |
      |-10|
      |-5 |
      | 0 |
      
  @tag2
  Scenario Outline: Invalid Gender
    Given I have an health calculator
    When I compute the ideal weight for an invalid gender <g>
    Then the system raise an exception
    
   	Examples: 
      | g |
      |'n'|
      |'y'|
      |'4'|

  @tag3
  Scenario Outline: Negative Weight Result
    Given I have an health calculator
    When I compute the ideal weight for gender <g> and height <h> and gives a negative result
    Then the system raise an exception
    
   	Examples: 
      | g | h |
      |'m'| 83|
      |'m'| 40|
      |'w'| 66|
      |'w'| 30|
      
	@tag4
  Scenario Outline: Negative Weight Result
    Given I have an health calculator
    When I compute the ideal weight for gender <g> and height <h>
    Then the system return a feasible result <value>
    
   	Examples: 
      | g |  h | value |
      |'w'| 160| '56' |
      |'w'| 156|'53.6'|
      |'m'| 180|'72.5'|
      |'m'| 174|'68' |
