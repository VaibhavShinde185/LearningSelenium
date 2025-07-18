package com.thetestingacademy.ex_selenium.seleniumBasicsDay4;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class selenium025 {
    // #no-such-element-exception
    // Error: https://www.selenium.dev/documentation/webdriver/troubleshooting/errors#no-such-element-exception
    // Difference between Tread.sleep and "driver.manage().timeouts().implicitlyWait()"

    @Description("Implicit Wait")
    @Test
    public void test_verify_print_imac_price() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        driver.findElement(By.id("js-login-btn")).click();

        driver.findElement(By.id("js-notification-box-msg"));
        driver.quit();
    }

}

//                Only one implicit wait is active at a time.
//                If you set it again later in the script, it overwrites the previous one.