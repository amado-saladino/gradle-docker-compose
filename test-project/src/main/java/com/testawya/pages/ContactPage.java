package com.testawya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="FullName")
    WebElement textName;

    @FindBy(id="Email")
    WebElement textEmail;

    @FindBy(id="Enquiry")
    WebElement textQuery;

    @FindBy(name = "send-email")
    WebElement buttonSubmit;

    @FindBy(css = "div.result")
    WebElement labelResult;

    public void sendInquiry(String name, String email, String query) {
        enterText(textName, name);
        enterText(textEmail, email);
        enterText(textQuery, query);
        clickElement(buttonSubmit);
    }

    public boolean querySent(String message) {
        return message.equals(labelResult.getText().trim());
    }
}
