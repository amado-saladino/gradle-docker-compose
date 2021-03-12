package com.testawya.testcases;

import com.testawya.pages.HomePage;
import com.testawya.pages.LoginPage;
import com.testawya.pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Helper;

public class RegisterTest extends TestCase {
    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;
    String email, password;

    @BeforeClass
    public void setupClass() {
        email = fakeDataGenerator.getEmail();
        password = fakeDataGenerator.getPassword();
        fakeDataGenerator.generateLocalDate();
        homePage = new HomePage(driver);
        registerPage = homePage.openRegistration();
    }

    @Test
    void testRegistration() {
        registerPage.setUserIdentifier(fakeDataGenerator.getMaleFirstName(), fakeDataGenerator.getMaleLastName(), email, fakeDataGenerator.getCompany());
        registerPage.selectDateOfBirth(fakeDataGenerator.getDay(), fakeDataGenerator.getMonth(), fakeDataGenerator.getYear());
        registerPage.setPassword(password);
        registerPage.register();
        Assert.assertTrue(registerPage.isRegistered());
        Helper.takeScreenshot(driver, "test registration");
    }

    @Test(dependsOnMethods = {"testRegistration"})
    public void relogin() {
        registerPage.logout();
        loginPage = homePage.clickLogin();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @AfterClass
    public void teardown() {
        loginPage.logout();
    }
}
