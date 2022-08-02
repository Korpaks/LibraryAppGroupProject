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
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserStory07_StepDef {
    String borrowedBookName;
    String dateBorrowed;
    LoginPage login = new LoginPage();
    BooksModule books = new BooksModule();
    BasePage base = new BasePage();

    @Given("the student on the home page")
    public void theStudentOnTheHomePage() {
        login.loginStudent();
    }

    @When("the user searches book name called {string}")
    public void the_user_searches_book_name_called(String bookName) {
        books.searchInput.sendKeys(bookName);
        borrowedBookName = bookName;
    }

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        BrowserUtils.waitFor(2);
        books.borrowFirstSearchedBook.click();

    }

    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String borrowingBooks) {
        base.borrowedBooks.click();
        BrowserUtils.waitFor(3);
        WebElement nameOfBorrowedBook = Driver.getDriver().findElement(By.xpath("//tr[14]/td[2]"));

        dateBorrowed = Driver.getDriver().findElement(By.xpath("//tr[14]/td[3]")).getText();
        BrowserUtils.waitFor(3);
        Assertions.assertEquals(borrowedBookName, nameOfBorrowedBook.getText());

    }

    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        BrowserUtils.waitFor(2);
        DBUtilities.runQuery("select name, borrowed_date from book_borrow inner join books b on book_borrow.book_id = b.id where borrowed_date ='" +dateBorrowed+ "'");
        System.out.println(dateBorrowed);
        String DBbookname = DBUtilities.getFirstRowFirstColumn();
        Assertions.assertEquals(borrowedBookName, DBbookname);
    }


}
