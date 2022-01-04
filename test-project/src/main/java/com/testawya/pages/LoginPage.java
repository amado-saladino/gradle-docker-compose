package com.testawya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement textEmail;

    @FindBy(id ="Password")
    WebElement textPassword;

    @FindBy(css = "button.login-button")
    WebElement buttonLogin;

    @FindBy(css = "div.message-error.validation-summary-errors ul li")
    WebElement labelError;

    @FindBy(css="span.field-validation-error")
    WebElement labelWrong;

    public void login(String mail, String password) {
        enterText(textEmail, mail);
        enterText(textPassword, password);
        clickElement(buttonLogin);
    }

    public boolean isError(String message) {
        return labelError.isDisplayed() &&
                labelError.getText().equals(message);
    }

    public boolean isWrong() {
        return labelWrong.isDisplayed()
                && labelWrong.getText().equals("Wrong email");
    }

    public boolean doInvalidLogin(String email, String password, String type, String message) {
        enterText(textEmail, email);
        enterText(textPassword, password);
        clickElement(buttonLogin);

        switch (type) {
            case "wrong mail":
                return labelWrong.isDisplayed()
                        && labelWrong.getText().equals(message);

            case "invalid password":
            case "not found":
                return labelError.isDisplayed() &&
                        labelError.getText().equals(message);
                default:
                    return false;
        }
    }
}
