package com.cydeo.library.pages;

import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LibraryUsersPage {

    public LibraryUsersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[.='Users']")
    public WebElement users;

    @FindBy (linkText = "Add User")
    public WebElement addUsers;

    //elements for adding users

    @FindBy (xpath = "//input[@name='full_name']")
    public WebElement fullName;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy (xpath = "//select[@name='user_group_id']")
    public WebElement userGroupNewUser;

    @FindBy (xpath = "(//select[@id='status'])[1]")
    public WebElement userStatusNewUser;

    @FindBy (xpath = "//input[@name='start_date']")
    public WebElement startDate;

    @FindBy (xpath = "//input[@name='end_date']")
    public WebElement endDate;

    @FindBy(id="address")
    public WebElement address;

    @FindBy (xpath = "//button[.='Save changes']")
    public WebElement saveChanges;

    @FindBy (xpath = "//div[.='The user has been created.']")
    public WebElement confirmedMessageForNewUser;

    Faker faker = new Faker();
    public void inputNewUser (){

        BrowserUtils.waitForVisibilityOf(fullName);
        fullName.sendKeys(faker.name().fullName());
        email.sendKeys(faker.internet().emailAddress());
        password.sendKeys(faker.internet().password());
        Select select = new Select(userGroupNewUser);
        select.selectByIndex(faker.number().numberBetween(0,1));
        Select select1 = new Select(userStatusNewUser);
        select1.selectByIndex(faker.number().numberBetween(0,1));
        startDate.sendKeys("2022-" + faker.number().numberBetween(1,6)+"-"+faker.number().numberBetween(1,30));
        endDate.sendKeys("2022-" + faker.number().numberBetween(7,12)+"-"+faker.number().numberBetween(1,30));
        address.sendKeys(faker.address().fullAddress());
    }
}
