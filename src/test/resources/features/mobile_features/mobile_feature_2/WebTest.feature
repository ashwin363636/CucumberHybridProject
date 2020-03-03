Feature: Testing the web view of the appliction

  Scenario Outline: Web view test
    Given Open Application in mobile view and Enter url
    When user enter "<username>" and "<password>"
    Then verify I see Logout Link
    Examples:
      | username | password |
      | system   | M00nb0y  |

  Scenario Outline: Create a new Box
    Given Open Application and Enter url
    When user enter "<Username>" and "<Password>"
    And Create a Box
    Then Box is Created in the system
    And I can access the box name in Login Action
    And I can access the box name in Login Step defination

    Examples:
      |Username|Password|
      |system |M00nb0y |