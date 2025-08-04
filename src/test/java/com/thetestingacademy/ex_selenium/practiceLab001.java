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

public class practiceLab001 {


    @Test
    public void testWebTable() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--inprivate");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));
        submit.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"username\"]"));


        }

    }

