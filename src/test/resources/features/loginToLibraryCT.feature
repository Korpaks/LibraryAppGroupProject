Feature: Login to LibraryCT

  User Story: As a user, I should be able login to LibraryCT

   Scenario: User enters invalid email address or password
      Given user is on the loginPage
      When user enters invalid email address or password
      And student click sign in button
      Then verify the error message "Sorry, Wrong Email or Password"
@wip
    Scenario:
      Given librarian login page
      Then verify that the title is "Login - Library"
      When librarian enters valid email and password
      And librarian clicks sign in button
      Then verify that there are 3 models on the page