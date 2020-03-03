Feature: Testing the like and destroying of twite

  @Sequential
  Scenario: Create, Like and destroy a twite
    Given I am authenticated into Twitter application
    When I make a random twite
    Then the twite is created on my wall
    And I can Like my last twite
    And I can Unlike my last twite
