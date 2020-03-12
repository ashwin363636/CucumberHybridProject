Feature: Testing the web view of the Zero bank

  Scenario Outline: Pay a bill
    Given Open Application in Web view and Enter url
    When user enter "<username>" and "<password>" in Zero BAnk App
    Then I can pay my bill
      | Sprint | Savings | 100 | 2019-09-28 | Test Payment |
    #And I see a success message "The payment was successfully submitted."
    And I can Logout Link
    Examples:
      | username | password |
      | username | password |
