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
Feature: Calculate Basal Metabolic Rate
  As a user of the health calculatorI want to calculate the basal metabolic rate according to the parameters entered so that I can know the resulting of this health measurement

  @tag1
  Scenario Outline: Invalid Height
    Given  I have an health calculator
    When I compute the basal metabolic rate for an invalid height <h>
    Then the system raises an exception

    Examples: 
      | h |
      |-40|
      |-18|
      | 0 |

   @tag2
  Scenario Outline: Invalid Weight
    Given  I have an health calculator
    When I compute the basal metabolic rate for an invalid gender <g>
    Then the system raises an exception

    Examples: 
      | g |
      |'h'|
      |'.'|
      |'9'|

  @tag3
  Scenario Outline: Invalid Age
    Given  I have an health calculator
    When  I compute the basal metabolic rate for a negative age <a>
    Then the system raises an exception

    Examples: 
      | a |
      |-87|
      |-4|
      |-1|
   
   @tag4
  Scenario Outline: Invalid Weight
    Given  I have an health calculator
    When I compute the basal metabolic rate for an invalid weight <w>
    Then the system raises an exception

    Examples: 
      | w |
      |-8|
      |-57|
      |0| 
	
	@tag5      
	Scenario Outline: Negative Result for Weight (only possible for women)
		Given I have an health calculator
		When I compute the basal metabolic rate of gender 'w' with a combination of height <h>, weight <w> and age <a> whose result is a negative weight
		Then the system raises an exception
		
		  Examples: 
      | h | w  | a|
      | 2 | 10 |25|
      |10 | 10 |1 | 
      | 34| 2  |34|

	@tag6
	Scenario Outline: Given valid parameters
		Given  I have an health calculator
		When I compute the basal metabolic rate for the given valid parameters <w> , <h> , <g> , <a>
		Then the system returns a valid result <result>
		  Examples: 
      | h | w  | a| g | result|
      | 160| 50 |25|'w'|'1214'|
      |189|72|45|'w'|'1515.25' |
      | 210| 90|34|'m'|'2047.5'|
      |134|46|9|'m'|'1257.5'|