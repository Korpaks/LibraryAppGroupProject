@luka
Feature: Login to LibraryCT

  User Story: As a user, I should be able login to LibraryCT

  Scenario: User enters invalid email address or password
    Given user is on the loginPage
    When user enters invalid email address or password
    And student click sign in button
    Then verify the error message "Sorry, Wrong Email or Password"