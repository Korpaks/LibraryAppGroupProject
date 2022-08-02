package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")
    public WebElement signinBtn;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMessage;

//    public void loginToPage(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        emailInput.sendKeys("librarian3@library");
//        passwordInput.sendKeys("Bqq9Ru0W");
//        signinBtn.click();
//    }

    public void loginStudent(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        emailInput.sendKeys("student2@library");
        passwordInput.sendKeys("zyxa10vg");
        signinBtn.click();
    }
    public void loginLibrarian(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        emailInput.sendKeys("librarian1@library");
        passwordInput.sendKeys("qU9mrvur");
        signinBtn.click();
    }



    public void negativeScenarioLogin(){
        Faker faker =new Faker();
        emailInput.sendKeys(faker.internet().emailAddress());
        passwordInput.sendKeys(faker.internet().password());
    }



}
