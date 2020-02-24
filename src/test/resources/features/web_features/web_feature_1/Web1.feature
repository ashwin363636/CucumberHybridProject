Feature: Testing the login feature
  so we can verify no unauthorised user
  can login to the system

  Scenario Outline: Web failure Test
    Given Open Application and Enter url
    When user enter "<Username>" and "<Password>"
    Then verify I see Logout Link

    Examples:
      | Username | Password  |
      | system1   | QwertY123   |
      | system  | M00nb0y |

  Scenario Outline: Web Second Test
    Given Open Application and Enter url
    When user enter "<Username>" and "<Password>"
    Then verify I see Logout Link

    Examples:
      | Username | Password |
      | system   | M00nb0y  |