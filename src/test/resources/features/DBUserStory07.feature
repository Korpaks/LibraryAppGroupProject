@nihat
Feature: As a students, I should be able to borrow book

 @db@db
Scenario: Student borrow new book
 Given the "student" on the home page
 And the user navigates to "Books" page
 And the user searches book name called "Waiting for the Barbarians"
 When the user clicks Borrow Book
 Then verify that book is shown in "Borrowing Books” page
 And verify logged student has same "Waiting for the Barbarians" book in database