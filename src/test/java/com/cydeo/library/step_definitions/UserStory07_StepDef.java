package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStory07_StepDef {

    LoginPage login = new LoginPage();
    BooksModule book = new BooksModule();

    @Given("the student on the home page")
    public void theStudentOnTheHomePage() {
        login.loginStudent();
    }

    @When("the user searches book name called {string}")
    public void the_user_searches_book_name_called(String bookName) {
        book.searchInput.sendKeys(bookName);
    }

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        BrowserUtils.waitFor(2);
        book.borrowFirstSearchBook.click();
    }

    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String borrowingBooks) {

    }

    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }


}
