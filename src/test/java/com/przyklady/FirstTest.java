package com.przyklady;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {


    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void katal1onAmazonAWSTest(){

        WebElement firstNameInputField = driver.findElement(By.id("first-name"));
        firstNameInputField.clear();
        firstNameInputField.sendKeys("Karol");

        WebElement lastNameInputField = driver.findElement(By.id("last-name"));
        lastNameInputField.clear();
        lastNameInputField.sendKeys("Nazwisko");

        driver
                .findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"))
                .click();

        WebElement dateofBirthInputField = driver.findElement(By.id("dob"));
        dateofBirthInputField.clear();
        dateofBirthInputField.sendKeys("05/22/2010");

        WebElement addressInputField = driver.findElement(By.id("address"));
        addressInputField.clear();
        addressInputField.sendKeys("Kowalskiego 12");

        WebElement emailInputField = driver.findElement(By.id("email"));
        emailInputField.clear();
        emailInputField.sendKeys("karol.kowalski@mailinator.com");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("Pass123");

        WebElement companyInputField = driver.findElement(By.id("company"));
        companyInputField.clear();
        companyInputField.sendKeys("Kowalix");

        Select roleDropdown = new Select(driver.findElement(By.id("role")));
        roleDropdown.selectByVisibleText("QA");

        WebElement commentInputField = driver.findElement(By.id("comment"));
        commentInputField.clear();
        commentInputField.sendKeys("This is my comment");

        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.findElement(By.id("submit-msg")).isDisplayed());
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
