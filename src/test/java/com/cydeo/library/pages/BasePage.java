package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//span[.='Dashboard']")
    public WebElement dashboardLink;

    @FindBy(xpath="//span[.='Users']")
    public WebElement usersLink;

    @FindBy(xpath="//span[.='Books']")
    public WebElement booksLink;

    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userNameLink;

    @FindBy(xpath = "//h2[@id='user_count']")
    public WebElement userCount;

    @FindBy (xpath = "//h2[@id='book_count']")
    public WebElement bookCount;

    @FindBy (xpath = "//h2[@id='borrowed_books']")
    public WebElement borrowedBookCount;

    @FindBy (id = "menu_item")
    public List<WebElement> studentModuleNum;

}
