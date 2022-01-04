package com.testawya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProductPage
 */
public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css="h1")
    WebElement productTitle;

    @FindBy(css="li.ui-menu-item")
    WebElement itemSearchList;

    public ProductPage search(String keyword) {
        System.out.println("EXPLICIT WAIT");
        enterText(textSearch, keyword);
        waitForElement(itemSearchList);
        clickElement(itemSearchList);
        return new ProductPage(driver);
    }

    public boolean isProductFound(String title) {
        return productTitle.getText().equalsIgnoreCase(title);
    }
}