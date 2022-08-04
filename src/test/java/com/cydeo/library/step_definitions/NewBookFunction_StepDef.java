package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class NewBookFunction_StepDef {

    LoginPage loginPage = new LoginPage();
    BooksModule booksModule = new BooksModule();



    @Given("librarian is on the Home Page")
    public void librarian_is_on_the_home_page() {
        loginPage.loginLibrarian();

    }
    @When("librarian clicks on Books module")
    public void librarian_clicks_on_books_module() {
        loginPage.booksLink.click();
    }
    @When("librarian click +Add Book button")
    public void librarian_click_button() {
        booksModule.addBooks.click();
    }
    @When("librarian enters BookName, ISBN, Year, Author, and Description")
    public void librarian_enters_book_name_isbn_year_author_and_description() {
        booksModule.addBookName_input.sendKeys("JAVA11");
        booksModule.addIsbn_input.sendKeys("15333");
        booksModule.addYear_input.sendKeys("2011");
        booksModule.addAuthor_input.sendKeys("Saim");
        Select select = new Select(Driver.getDriver().findElement(By.id("book_group_id")));
        select.selectByVisibleText("Fan-Fiction");
        booksModule.bookDescription_input.sendKeys("Java is fun?!");
    }
    @When("librarian clicks save changes")
    public void librarian_clicks_save_changes() throws InterruptedException {
        Thread.sleep(3000);
        booksModule.submitBookBtn.click();
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() throws InterruptedException {
        BrowserUtils.waitForVisibility(booksModule.searchInput,10);
        booksModule.searchInput.sendKeys("JAVA11");
        Thread.sleep(3000);
        String expectedBook = "JAVA11";
        String actualBook = Driver.getDriver().findElement(By.xpath("//tr/td[3]")).getText();
        Assert.assertEquals(expectedBook,actualBook);
    }

}
