@login
Feature: User should be able to interact with login function

  @validLogin
  Scenario:  I, as a user, with valid login credentials, can log into their account.
    Given I'm on the login page
    When I enter a valid credentials
    Then I see the page with the title
      | Home | Dashboard - VoterVoice Administrator Site |

  @invalidLogin
  Scenario: I, as a user, with invalid login credentials will see an error message.
    Given I'm on the login page
    When I enter invalid credentials
    Then I see error message
      | Invalid UserName/Password Combination |

  @blankField
  Scenario Outline: I, as a user, who leaves the field blank will see an error message.
    Given I'm on the login page
    When I login with a blank <field>
    Then I see "<msg1>"  "<msg2>"

    Examples:
      | field                 | msg1                | msg2                |
      | username              | * Require User Name |                     |
      | password              |                     | * Require Password  |
      | username and password | * Require User Name | * Require Password  |
