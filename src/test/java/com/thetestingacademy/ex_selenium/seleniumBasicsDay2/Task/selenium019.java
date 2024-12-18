package com.thetestingacademy.ex_selenium.seleniumBasicsDay2.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class selenium019 {

    @Test
    public void testAwesomeQA(){

        WebDriver driver = new EdgeDriver();
        driver.navigate().to(" https://awesomeqa.com/ui/index.php?route=account/register");
        driver.manage().window().maximize();

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.id("input-email")).sendKeys("Matimes@mt.com");
        driver.findElement(By.name("telephone")).sendKeys("02228508246");
        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.name("confirm")).sendKeys("Password123");
        driver.findElement(By.name("newsletter")).click();

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary' and @value='Continue']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

       // Assert.assertEquals(errorMessage.getText(), "//div[@class='alert alert-danger alert-dismissible']");

//        driver.quit();
    }

}
