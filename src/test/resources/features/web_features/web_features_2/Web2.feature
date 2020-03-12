Feature: Testing the web view of the Zero bank

  Scenario Outline: Money transfer test
    Given Open Application in Web view and Enter url
    When user enter "<username>" and "<password>" in Zero BAnk App
    Then I can do a Money transfer
    And I see a success message "You successfully submitted your transaction."
    And I can Logout Link
    Examples:
      | username | password |
      | username | password |