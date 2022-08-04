package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.DBUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;

public class UserStory06_StepDef {

    BooksModule books = new BooksModule();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        BrowserUtils.waitForClickablility(books.addBooks, 5);
        books.addBooks.click();
    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        books.addBookName_input.sendKeys(bookName);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {
        books.addIsbn_input.sendKeys(isbn);
    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
       books.addYear_input.sendKeys(year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        books.addAuthor_input.sendKeys(author);
    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {
        Select select = new Select(books.addBookCategory_dropdown);
        select.selectByVisibleText(bookCategory);
    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
        books.submitBookBtn.click();
    }

    @Then("verify {string} message is displayed")
    public void verifyMessageIsDisplayed(String message) {
        BrowserUtils.waitForVisibilityOf(books.bookHasBeenAddedMessage);
        Assertions.assertEquals(books.bookHasBeenAddedMessage.getText(), message);
    }

    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {
        DBUtilities.runQuery("select name, added_date from books order by added_date desc");
        String DBbookName = DBUtilities.getFirstRowFirstColumn();
        Assertions.assertEquals(bookName, DBbookName);

    }
}
