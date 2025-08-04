package com.thetestingacademy.ex_selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.contains;

public class practiceLab001 {


    @Test
    public void testWebTable() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=800,600");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        if (driver.getPageSource().contains("Sign in to VWO platform")){
            System.out.println("Verified");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");


        WebElement userName = driver.findElement(By.id("login-username"));
        userName.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("P@ssw0rd369");

        WebElement signInButton = driver.findElement(By.id("js-login-btn"));
        signInButton.click();

        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.textToBePresentInElement
                (errorMessage, "Your email, password, IP address or location did not match"));

        Assert.assertEquals(errorMessage.getText(),
                "Your email, password, IP address or location did not match");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        WebElement freeTrial = driver.findElement(By.partialLinkText("free trail"));
        freeTrial.click();


        }

    }

