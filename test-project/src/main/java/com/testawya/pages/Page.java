package com.testawya.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    private JavascriptExecutor jsRunner;
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jsRunner = (JavascriptExecutor) driver;
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    protected void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    @FindBy(linkText = "Log in")
    WebElement linkLogin;

    @FindBy(linkText = "Log out")
    WebElement linkLogout;

    @FindBy(linkText = "My account")
    WebElement linkMyAccount;

    @FindBy(linkText = "Register")
    WebElement linkRegister;

    @FindBy(css = "img[alt='nopCommerce demo store']")
    WebElement imageLogo;

    @FindBy(linkText = "Contact us")
    WebElement linkContact;

    @FindBy(id="small-searchterms")
    WebElement textSearch;

    @FindBy(id="ui-id-1")
    WebElement linkSearchResults;

    public WebElement waitForElement(By selector) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        return wait.until(webdriver-> {
            return webdriver.findElement(selector);
        });
    }

    void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public ProductPage search(String keyword) {
        enterText(textSearch, keyword);
        WebElement product = waitForElement(By.cssSelector("li.ui-menu-item"));
        clickElement(product);
        return new ProductPage(driver);
    }

    public LoginPage clickLogin() {
        clickElement(linkLogin);
        return new LoginPage(driver);
    }

    public ContactPage contactUs() {
        scrollPage();
        clickElement(linkContact);
        return new ContactPage(driver);
    }

    void runScript(String script, Object... args) {
        jsRunner.executeScript(script, args);
    }

    void scrollPage() {
        runScript("scrollTo(0,document.body.scrollHeight)");
    }

    public void logout() {
        clickElement(linkLogout);
    }

    public boolean isLoggedIn() {
        return linkLogout.isDisplayed() &&
                linkMyAccount.isDisplayed();
    }

    public RegisterPage openRegistration() {
        clickElement(linkRegister);
        return new RegisterPage(driver);
    }

    void selectDropdownItemByText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public HomePage openHomePage() {
        clickElement(imageLogo);
        return new HomePage(driver);
    }
}
