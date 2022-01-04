package com.testawya.testcases;

import com.ahmed.excelizer.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import utilities.FakeDataGenerator;
import utilities.Helper;
import utilities.PropertyReader;
import utilities.WebDriverFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestCase {
    static WebDriver driver;
    FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

    @BeforeSuite
    void setupTest() {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.navigate().to(PropertyReader.getProperty("BASE_URL"));
    }

    @AfterSuite
    public void teardownTest() {
        WebDriverFactory.stopDriver();
    }

    @DataProvider(name = "dataSource")
    Object[][] readData(ITestNGMethod testNGMethod) {
        return ExcelReader.loadTestData("data\\" + testNGMethod.getRealClass().getSimpleName() +".xlsx",testNGMethod.getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Test Failed");
            Helper.takeScreenshot(driver,result.getName());
        }
    }
}
