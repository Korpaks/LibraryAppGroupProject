@dusan @student
Feature: student login functionality

  User Story:
  As a user, I should be able to login to LibraryCT

  Scenario Outline: login for student
    Given user is on login page
    And verify that the URL is "https://library2.cydeo.com/login.html"
    When student enters valid "<email>" address and "<password>"
    And student click sing in butt
    Then verify that there are 2 models on the page
    Examples:
      | email          | password |
      | student1@library  | d5fv9BtX |
      | student2@library  | zyxa10vg |
      | student3@library  | rPjgZ86a |
      | student4@library  | pG3V6qaL |
      | student5@library  | i1oDgf2d |
      | student6@library  | NXhpXJdC |
      | student7@library  | QfYjDNXj |
      | student8@library  | 1DaJSz1z |
      | student9@library  | DFDYll1P |
      | student10@library | F8u6OrI2 |
      | student11@library | 4VRMTsAB |
      | student12@library | 8ENtWqOe |
      | student13@library | Y0kaXNMa |
      | student14@library | bL1twuqT |
      | student15@library | 9WB9sVtF |
      | student16@library | 2Ziw6vOx |
      | student17@library | FmmXHzpF |
      | student18@library | qxt5XZgZ |
      | student19@library | xDxywYeJ |
      | student20@library | nGdNzH1e |
      | student21@library | y5pYTlqY |
      | student22@library | 2eMI9Uyk |
      | student23@library | zzTYIurO |
      | student24@library | OwsiR4u5 |
      | student25@library | gb6SmZjb |
      | student26@library | zC7BUYHs |
      | student27@library | E1uZrsAu |
      | student28@library | tJ93UQS3 |
      | student29@library | g8EyNm9B |
      | student30@library | QX6FWzj6 |
      | student31@library | yEKjyg5T |
      | student32@library | RqJkWmUu |
      | student33@library | 4V3Kd1YG |
      | student34@library | JySGHP8G |
      | student35@library | r2oOkz9m |
      | student36@library | WV2WrNrk |
      | student37@library | sqs9B1TY |
      | student38@library | nca2fAGL |
      | student39@library | kCrQEt6X |
      | student40@library | ZkFJCgOd |
      | student41@library | FsOQE0Xq |
      | student42@library | 1oXkp7l2 |
      | student43@library | AKDv7j74 |
      | student44@library | GaPt5us4 |
      | student45@library | c4GeJZ54 |
      | student46@library | pZg19ua5 |
      | student47@library | yabV3kwK |
      | student48@library | 1i33g2PC |
      | student49@library | l1Wj8WGv |
      | student50@library | TqKXmAC4 |
      | student51@library | 49iP65vD |
      | student52@library | E5idT5e8 |
      | student53@library | o8hqDkKg |
      | student54@library | vlrGqQPI |
      | student55@library | xBLy3ufr |
      | student56@library | 3JgJAhsi |
      | student57@library | O76CUuPE |
      | student58@library | WS3rm9xG |
      | student59@library | cJaTyCRJ |
      | student60@library | AoSFw44Y |
