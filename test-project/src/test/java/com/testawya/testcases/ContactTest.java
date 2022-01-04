package com.testawya.testcases;

import com.testawya.pages.ContactPage;
import com.testawya.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactTest extends TestCase {
    private HomePage homePage;
    private ContactPage contactPage;

    @BeforeClass
    void setup() {
        homePage = new HomePage(driver);
        contactPage = homePage.contactUs();
    }

    @Test
    void contactUs() {
        String name =  fakeDataGenerator.getFullName();
        String email = fakeDataGenerator.getEmail();
        String message = fakeDataGenerator.getRandomMessage();
        contactPage.sendInquiry(name, email, message);
        Assert.assertTrue(contactPage.querySent("Your enquiry has been successfully sent to the store owner."));
    }
}
