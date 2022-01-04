package com.testawya.testcases;

import com.testawya.pages.HomePage;
import com.testawya.pages.ProductPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Helper;
import utilities.PropertyReader;

import static com.testawya.testcases.TestCase.driver;

/**
 * SearchProductTest
 */
public class SearchProductTest extends TestCase {

    String keyword, product;

    @BeforeClass
    void setup() {
        product = PropertyReader.getProperty("PRODUCT");
        keyword = Helper.generateProductKeyword(product);
    }

    @Test
    void searchForProduct() {
        ProductPage productPage = new ProductPage(driver);
        productPage.search(keyword);
        Assert.assertTrue(productPage.isProductFound(product));
    }

    //this method below is used with fluent wait
    /*@Test
    void searchForProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.search(keyword);
        productPage.search(keyword);
        Assert.assertTrue(productPage.isProductFound(product));
    }*/
}