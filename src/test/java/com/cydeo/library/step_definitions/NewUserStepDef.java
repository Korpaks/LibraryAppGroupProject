package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibraryUsersPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewUserStepDef {

    LoginPage login = new LoginPage();
    LibraryUsersPage users = new LibraryUsersPage();

    int numberOfUsers;

    @Given("librarian is on the home page")
    public void librarian_is_on_the_home_page() {
        login.loginLibrarian();
        BrowserUtils.waitForVisibilityOf(users.userCount);
        BrowserUtils.waitFor(1);
        numberOfUsers = Integer.parseInt(users.userCount.getText());
        System.out.println(users.userCount.getText());
    }
    @When("librarian click User module")
    public void librarian_click_user_module() {
        BrowserUtils.waitForVisibilityOf(users.users);
        BrowserUtils.waitForClickablility(users.users, 10);
        users.users.click();
    }
    @When("librarian click Add User button")
    public void librarian_click_add_user_button() {
        users.addUsers.click();
    }
    @When("librarian fills out the user information")
    public void librarian_fills_out_the_user_information() {
        users.inputNewUser();
    }
    @When("librarian click save changes")
    public void librarian_click_save_changes() {
        users.saveChanges.click();
    }
    @Then("verify a new user is created")
    public void verify_a_new_user_is_created() {
        BrowserUtils.waitForVisibilityOf(users.confirmedMessageForNewUser);
        Assert.assertTrue(users.confirmedMessageForNewUser.isDisplayed());
        users.dashboardLink.click();
        BrowserUtils.waitForVisibilityOf(users.userCount);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Number of users not equal", numberOfUsers+1, Integer.parseInt(users.userCount.getText()));

    }
}
