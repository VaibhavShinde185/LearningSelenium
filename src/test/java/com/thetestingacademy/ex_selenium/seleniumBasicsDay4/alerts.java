package com.thetestingacademy.ex_selenium.seleniumBasicsDay4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class alerts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // Selenium can not handle native pop ups

//        WebElement element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
//        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

//        element.click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");

        System.out.println("-----------------------------------------------");

//        elementConfirm.click();
//        Alert alert = driver.switchTo().alert();
////        alert.accept();
//        alert.dismiss();
////        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
//        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Cancel");

        System.out.println("-----------------------------------------------");

        elementPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vaibhav");
        alert.accept();


    }
}
