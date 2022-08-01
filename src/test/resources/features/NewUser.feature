@igor  @newUser @B26G5-69
Feature: adding new user functionality
  User Story: As a librarian, I should be able to add a new user

  Scenario: Verify librarian can add user

    Given librarian is on the home page
    When librarian click User module
    And librarian click Add User button
    When librarian fills out the user information
    And librarian click save changes
    Then verify a new user is created