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

import java.util.List;

public class UserStory07_StepDef {
    String borrowedBookName;
    String dateBorrowed;
    LoginPage login = new LoginPage();
    BooksModule books = new BooksModule();
    BasePage base = new BasePage();
    List<WebElement> tableRows;

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
        tableRows = Driver.getDriver().findElements(By.xpath("//tr")); // finding elements for each table row because it is dinamic, each table row is created when we borrow book
        int tableRawData = tableRows.size()-1; // setting up my index for finding the specific data at this specifi row
        WebElement nameOfBorrowedBook = Driver.getDriver().findElement(By.xpath("//tr["+tableRawData+"]/td[2]")); // inserting table row. size -1 to get the last row
        dateBorrowed = Driver.getDriver().findElement(By.xpath("//tr["+tableRawData+"]/td[3]")).getText(); // finding the date of the that borrowed book since it will help us in the query to locate our book easier
        BrowserUtils.waitFor(1);
        Assertions.assertEquals(borrowedBookName, nameOfBorrowedBook.getText());

    }

    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {
        BrowserUtils.waitFor(2);
        DBUtilities.runQuery("select name, borrowed_date from book_borrow inner join books b on book_borrow.book_id = b.id where borrowed_date ='" +dateBorrowed+ "'"); // running query to find the book where the borrowed date was found on UI
        System.out.println(dateBorrowed); // printing the result just to confirm
        String DBbookname = DBUtilities.getFirstRowFirstColumn(); // getting the name of the book from DB
        Assertions.assertEquals(borrowedBookName, DBbookname);
    }


}
