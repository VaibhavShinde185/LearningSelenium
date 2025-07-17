package com.thetestingacademy.ex_selenium.seleniumBasicsDay4;

import com.google.common.base.Function;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class fluentWait {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void testVwoLoginNegative(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("admin@admin.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("password@123");

        driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']")).click();

                FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);


        WebElement errorMessage = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
            }
        });

        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

        driver.quit();


    }

}
