package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewBookFunction_StepDef {

    LoginPage loginPage = new LoginPage();
    BooksModule booksModule = new BooksModule();
    BasePage basePage = new BasePage();


    @Given("librarian is on the Home Page")
    public void librarian_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.emailInput.sendKeys("librarian3@library");
        loginPage.passwordInput.sendKeys("Bqq9Ru0W");
        loginPage.signinBtn.click();
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
        Faker faker = new Faker();
        booksModule.addBookName_input.sendKeys("Java8");
        booksModule.addIsbn_input.sendKeys(faker.code().imei());
        booksModule.addYear_input.sendKeys("1805");
        booksModule.addAuthor_input.sendKeys(faker.book().author());
        Select select = new Select(Driver.getDriver().findElement(By.id("book_group_id")));
        select.deselectByVisibleText("Science Fiction");
        booksModule.bookDescription_input.sendKeys(faker.shakespeare().hamletQuote());
    }
    @When("librarian clicks save changes")
    public void librarian_clicks_save_changes() {
        booksModule.submitBookBtn.click();
    }
    @Then("verify a new book is added")
    public void verify_a_new_book_is_added() {
        String expectedBook = "Java8";
        String actualBook = Driver.getDriver().findElement(By.xpath("//tr/td[3]")).getText();
        Assert.assertEquals(expectedBook,actualBook);
    }

}
