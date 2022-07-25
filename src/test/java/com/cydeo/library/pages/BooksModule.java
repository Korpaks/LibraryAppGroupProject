package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BooksModule {

    public BooksModule() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "tpl/add-book.html")
    public WebElement addNewBookLink;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement addBookName_input;

    @FindBy(xpath = "//input[@name='isbn']")
    public WebElement addIsbn_input;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement addYear_input;

    @FindBy(xpath = "//input[@name='author']")
    public WebElement addAuthor_input;

    @FindBy(id = "book_group_id")
    public WebElement addBookCategory_dropdown;

    Select selectObj = new Select(Driver.getDriver().findElement(By.id("book_group_id")));


}
