@logout
Feature: Logout


  Scenario: I, as a user, can logout
    Given I'm on Home page
    When I select Logout bottom from User Menu
    Then I'm on the login page