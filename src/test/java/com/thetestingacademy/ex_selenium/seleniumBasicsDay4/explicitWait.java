package com.thetestingacademy.ex_selenium.seleniumBasicsDay4;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class explicitWait {


    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testVwoLoginNegative(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("admin@admin.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("password@123");

        driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']")).click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@id='js-notification-box']"));

        // Here is the explicitly wait added in the script
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessage, "Your email, password, IP address or location did not match"));

        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
