package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewBookFunction_StepDef {

    LoginPage loginPage = new LoginPage();
    BooksModule booksModule = new BooksModule();
    BasePage basePage = new BasePage();


    @Given("librarian is on the Home Page")
    public void librarian_is_on_the_home_page() {
        loginPage.loginToPage("env","librarian_username","librarian_password");
    }
    @When("librarian clicks on Books module")
    public void librarian_clicks_on_books_module() {
        basePage.booksLink.click();
    }
    @When("librarian click +Add Book button")
    public void librarian_click_button() {
        booksModule.addNewBookLink.click();
    }
    @When("librarian enters BookName, ISBN, Year, Author, and Description")
    public void librarian_enters_book_name_isbn_year_author_and_description() {

    }
    @When("librarian clicks save changes")
    public void librarian_clicks_save_changes() {
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() {
    }

}
