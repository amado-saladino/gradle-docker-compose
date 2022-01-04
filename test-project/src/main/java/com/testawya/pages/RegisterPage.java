package com.testawya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="gender-male")
    WebElement genderMale;

    @FindBy(id="gender-female")
    WebElement genderFemale;

    @FindBy(id="FirstName")
    WebElement textFirstName;

    @FindBy(id="LastName")
    WebElement textLastName;

    @FindBy(name = "DateOfBirthDay")
    WebElement dropdownDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement dropdownMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement dropdownYear;

    @FindBy(id="Email")
    WebElement textEamil;

    @FindBy(id="Company")
    WebElement textcompany;

    @FindBy(id="Password")
    WebElement textPassword;

    @FindBy(id="ConfirmPassword")
    WebElement textConfirmPassword;

    @FindBy(id="register-button")
    WebElement buttonRegister;

    @FindBy(css = "div.result")
    WebElement labelResult;

    public void setUserIdentifier(String firstName, String lastName, String email, String company) {
        clickElement(genderMale);
        enterText(textFirstName,firstName);
        enterText(textLastName,lastName);
        enterText(textEamil,email);
        enterText(textcompany,company);
    }

    public void setPassword(String password) {
        enterText(textPassword,password);
        enterText(textConfirmPassword,password);
    }

    public void register() {
        clickElement(buttonRegister);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        selectDropdownItemByText(dropdownDay,day);
        selectDropdownItemByText(dropdownMonth,month);
        selectDropdownItemByText(dropdownYear,year);
    }

    public boolean isRegistered() {
        return labelResult.getText().equals("Your registration completed");
    }
}
