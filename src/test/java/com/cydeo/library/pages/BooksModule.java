package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksModule{

    public BooksModule() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//i[@class='fa fa-plus']")
    public WebElement addNewBookLink;
    
    @FindBy(css = ".portlet-title [data-target]")
    public WebElement addBooks;


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

    @FindBy(id = "description")
    public WebElement bookDescription_input;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBookBtn;

    @FindBy(id = "book_categories")
    public WebElement bookCategory_dropdown;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    @FindBy(xpath = "//td[1]")
    public WebElement editBook;

    @FindBy(xpath = "//div[.='The book has been created.']")
    public WebElement bookHasBeenAddedMessage;

    @FindBy(xpath = "//td[1]")
    public WebElement borrowFirstSearchBook;

}
