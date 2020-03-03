Feature: Testing the like and destroying of twite

  @Sequential
  Scenario Outline: Create, Like and destroy a twite
    Given I am authenticated into Twitter application
    When I make a twite using the below datatable with "<Repetition>"
      | Column 1 | Column 2    | Column 3 |
      | Just     | random      | data     |
      | to       | concatenate | together |
    Then the twite is created on my wall
    And I can Like my last twite
    And I can Unlike my last twite

    Examples:
      | Repetition  |
      | Iteration 1 |
      | Iteration 2 |
  