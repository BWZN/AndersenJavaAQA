Feature: Testing of Login Page
Background:
  Given Set up driver

  Scenario Outline: Test of Login with valid values

    When I open Login page
    And I set valid mail <text1>
    And I set valid password <text2>
    And I click Submit button
    Then I redirect to profile page
    Examples:
      | text1 | text2 |
      | test | test |


  Scenario Outline: Test of Login with invalid values

    When I open Login page
    And I set valid mail <text1>
    And I set valid password <text2>
    And I click Submit button
    Then I check error message
    Examples:
      | text1 | text2 |
      |testtest@mail.mail| wrongPassExample |

  Scenario Outline: Test of Login with empty email

    When I open Login page
    And I set valid mail <text1>
    And I set valid password <text2>
    Then I check email requirement message
    Examples:
      | text1 | text2 |
      || wrongPassExample |

