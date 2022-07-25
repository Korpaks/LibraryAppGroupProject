Feature:Add a new book functionality

  @nihat
  Scenario: Librarian add a new book functionality
    Given librarian is on the Home Page
    When librarian clicks on Books module
    And librarian click +Add Book button
    When librarian enters BookName, ISBN, Year, Author, and Description
    And librarian clicks save changes
    Then verify a new book is added