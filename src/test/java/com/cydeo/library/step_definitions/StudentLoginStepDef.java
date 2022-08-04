package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentLoginStepDef {

    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @And("verify that the URL is {string}")
    public void verify_that_the_url_is(String url) {
            Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());
    }


    @When("student click sing in butt")
    public void student_click_sing_in_butt() {
    loginPage.signinBtn.click();
    }

    @Then("verify that there are {int} models on the page")
    public void verify_that_there_are_models_on_the_page(Integer numberOfModules) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals((int) numberOfModules, loginPage.studentModuleNum.size());
    }

    @Given("librarian login page")
    public void librarianLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @Then("verify that the title is {string}")
    public void verifyThatTheTitleIs(String title) {
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals("Title not equal", title, Driver.getDriver().getTitle());
    }



    @And("librarian clicks sign in button")
    public void librarianClicksSignInButton() {
        loginPage.signinBtn.click();
    }

    @When("student enters valid {string} address and {string}")
    public void studentEntersValidAddressAnd(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("librarian enters valid {string} and {string}")
    public void librarianEntersValidAnd(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }
}
