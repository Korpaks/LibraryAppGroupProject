package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.BooksModule;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.DBUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class UserStory03_StepDef {

    BasePage base = new BasePage();
    BooksModule books = new BooksModule();


    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String arg) {
//        Driver.getDriver().findElement(By.xpath("//span[.='"+arg+"']"));
        base.booksLink.click();
    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        books.bookCategory_dropdown.click();
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        List<String> allCategories =  BrowserUtils.dropdownOptionsAsString(books.bookCategory_dropdown);
        allCategories.remove(0);
        // get all options from UI for book categories in List of String
        DBUtilities.runQuery("select name from book_categories");
        List<String> dbCategories = DBUtilities.getColumnDataAsList(1);
        Assertions.assertEquals(allCategories, dbCategories);

    }
}
