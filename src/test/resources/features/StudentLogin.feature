@studentLogin
Feature: student login functionality

  User Story:
  As a user, I should be able to login to LibraryCT

  Scenario: login for student
    Given user is on login page
    And verify that the URL is "https://library2.cybertekschool/login.html"
    When student enters valid email address and password
    And student click sing in butt
    Then verify that there are 2 models on the page