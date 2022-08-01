package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.DBUtilities;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class UserStory02_StepDef {

    LoginPage login = new LoginPage();
    BasePage base = new BasePage();
    String borrowedBooksNumber;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
     login.emailInput.sendKeys(librarian+"1@library");
     login.passwordInput.sendKeys("qU9mrvur");
     login.signinBtn.click();
    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        BrowserUtils.waitForVisibilityOf(base.borrowedBookCount);
    borrowedBooksNumber = base.borrowedBookCount.getText();
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DBUtilities.runQuery("select count(*) from book_borrow where is_returned = 0");
        String dbBorrowedBooksNumber = DBUtilities.getFirstRowFirstColumn();
        Assertions.assertEquals(borrowedBooksNumber, dbBorrowedBooksNumber);
    }
}
