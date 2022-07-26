package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentLoginStepDef {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);


    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @And("verify that the URL is {string}")
    public void verify_that_the_url_is(String url) {
            Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());
    }

    @When("student enters valid email address and password")
    public void student_enters_valid_email_address_and_password() {
        loginPage.emailInput.sendKeys("student1@library");
        loginPage.passwordInput.sendKeys("d5fv9BtX");
    }

    @When("student click sing in butt")
    public void student_click_sing_in_butt() {
    loginPage.signinBtn.click();
    }

    @Then("verify that there are {int} models on the page")
    public void verify_that_there_are_models_on_the_page(Integer numberOfModules) {
        BrowserUtils.waitFor(1);
        Assert.assertEquals((int) numberOfModules, basePage.studentModuleNum.size());
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

    @When("librarian enters valid email and password")
    public void librarianEntersValidEmailAndPassword() {
        loginPage.emailInput.sendKeys("librarian1@library");
        loginPage.passwordInput.sendKeys("qU9mrvur");
    }

    @And("librarian clicks sign in button")
    public void librarianClicksSignInButton() {
        loginPage.signinBtn.click();
    }
}
