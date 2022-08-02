package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.DBUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class UserStory04_StepDef {

    BooksModule books = new BooksModule();

    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        BrowserUtils.waitForVisibilityOf(books.searchInput);
        books.searchInput.sendKeys(bookName);
    }
    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(books.editBook, 10);
        books.editBook.click();

    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        BrowserUtils.waitFor(2);
        String UIbookName = books.addBookName_input.getAttribute("value");
        String UIisbn = books.addIsbn_input.getAttribute("value");
        String UIyear = books.addYear_input.getAttribute("value");
        String UIauthor = books.addAuthor_input.getAttribute("value");
        String UIbookCategory = books.addBookCategory_dropdown.getAttribute("value");
        String UIdescription = books.bookDescription_input.getAttribute("value");

        DBUtilities.runQuery("select * from books where name='Clean Code' order by year");

        Map<String, String > rowMap = DBUtilities.getRowMap(1);

        Assertions.assertEquals(UIbookName, rowMap.get("name"));
        Assertions.assertEquals(UIisbn, rowMap.get("isbn"));
        Assertions.assertEquals(UIyear, rowMap.get("year"));
        Assertions.assertEquals(UIauthor, rowMap.get("author"));
        Assertions.assertEquals(UIbookCategory, rowMap.get("book_category_id"));
        Assertions.assertEquals(UIdescription, rowMap.get("description"));





    }
}
