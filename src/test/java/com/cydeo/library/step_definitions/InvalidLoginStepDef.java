package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidLoginStepDef
{

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("user is on the loginPage")
    public void user_is_on_the_login_page()
    {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters invalid email address or password")
    public void user_enters_invalid_email_address_or_password()
    {
        loginPage.negativeScenarioLogin();
    }
    @When("student click sign in button")
    public void student_click_sign_in_button()
    {
        loginPage.signinBtn.click();
    }
    @Then("verify the error message {string}")
    public void verify_the_error_message(String errorMsg)
    {
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        Assert.assertEquals(errorMsg, loginPage.errorMessage.getText());

    }

}
