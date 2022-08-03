package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.DBUtilities;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class UserStory07_StepDef {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    BooksModule booksModule = new BooksModule();
    BrowserUtils browserUtils = new BrowserUtils();

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String student) {
        loginPage.loginStudent();
    }
    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String books) {
        basePage.booksLink.click();
    }
    @Given("the user searches book name called {string}")
    public void the_user_searches_book_name_called(String bookName) {
        browserUtils.waitForVisibility(booksModule.searchInput,10);
        booksModule.searchInput.sendKeys(bookName + Keys.ENTER);
    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        browserUtils.waitForClickablility(booksModule.firstRowFirstTable,10);
        booksModule.firstRowFirstTable.click();
    }
    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verify_that_book_is_shown_in_borrowing_books_page() {
        Assertions.assertTrue(booksModule.notificationText.isDisplayed(),"Book borrowing failed!");
        basePage.borrowedBooks.click();
        String expectedBorrowedBookText = "NOT RETURNED";
        String actualBorrowedBookText = Driver.getDriver().findElement(By.xpath("(//td[.='Waiting for the Barbarians'])[last()]/following-sibling::td[4]")).getText();
        Assertions.assertEquals(expectedBorrowedBookText,actualBorrowedBookText,"Borrowed book text is not verified!");
    }
    @Then("verify logged student has same {string} book in database")
    public void verify_logged_student_has_same_book_in_database(String expectedBookName) {
        String query = "select b.name,bb.borrowed_date from users u                             inner join book_borrow bb on u.id = bb.user_id\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "where is_returned=1 and full_name='Test Student 1' " +
                "and name='"+expectedBookName+"'";

        DBUtilities.runQuery(query);

        String actualBookNameFromDB = DBUtilities.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBookName,actualBookNameFromDB);

    }

}
