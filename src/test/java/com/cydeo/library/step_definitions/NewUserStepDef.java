package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
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
    BasePage base = new BasePage();
    int numberOfUsers;

    @Given("libraian is on the home page")
    public void libraian_is_on_the_home_page() {
        login.loginLibrarian();
        BrowserUtils.waitForVisibilityOf(base.userCount);
        BrowserUtils.waitFor(1);
        numberOfUsers = Integer.parseInt(base.userCount.getText());
        System.out.println(base.userCount.getText());
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
        base.dashboardLink.click();
        BrowserUtils.waitForVisibilityOf(base.userCount);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Number of users not equal", numberOfUsers+1, Integer.parseInt(base.userCount.getText()));

    }
}
