package com.cydeo.library.pages;

import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
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

//    public void loginToPage(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        emailInput.sendKeys("librarian3@library");
//        passwordInput.sendKeys("Bqq9Ru0W");
//        signinBtn.click();
//    }

    public void loginStudent(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        emailInput.sendKeys("student1@library");
        passwordInput.sendKeys("d5fv9BtX");
        signinBtn.click();
    }
    public void loginLibrarian(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        emailInput.sendKeys("librarian1@library");
        passwordInput.sendKeys("qU9mrvur");
        signinBtn.click();
    }



}
