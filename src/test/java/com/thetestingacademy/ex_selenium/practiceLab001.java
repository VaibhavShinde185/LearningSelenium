package com.thetestingacademy.ex_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class practiceLab001 {

    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("macmini");
        driver.findElement(By.xpath("//span[@class='gh-search-button__label']")).click();

        Thread.sleep(10000);

//        List<WebElement> serachTitles = driver.findElements(By.xpath("//div[@class='s-item__title'/span]"));
//        List<WebElement> serachTitlesPrices = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        List<WebElement> searchTitles = driver.findElements(By.xpath("//h3[@class='s-item__title']"));
        List<WebElement> searchPrices = driver.findElements(By.xpath("//span[@class='s-item__price']"));


        int size = Math.min(searchTitles.size(), searchPrices.size());

        for (int i = 0; i < size; i++) {
            System.out.println("Title: " + searchTitles.get(i).getText().trim() + " || Price: " + searchPrices.get(i).getText().trim());
            System.out.println();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
