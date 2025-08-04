package com.thetestingacademy.ex_selenium.xpathXPathAxesDay3;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class selenium023 {

    @Description("Verify that Ebay print the prices of mac")
    @Test
    public void test_verify_print_imac_price(){

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.xpath("//button[@value='Search']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        searchButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Print all the titles
        List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@role='heading']"));
        List<WebElement> searchTitlesPrices = driver.findElements(By.xpath(
                "//span[@class='su-styled-text primary bold large-1 s-card__price']"));

        int size = Math.min(searchTitles.size(), searchTitlesPrices.size());
        for (int i = 0; i < size; i++) {

            System.out.println("Title: " + searchTitles.get(i).getText() + " || " + "Price: " + searchTitlesPrices.get(i).getText());
            System.out.println();

            // Find Max price and min Price Product

        }
        driver.quit();
    }

}
