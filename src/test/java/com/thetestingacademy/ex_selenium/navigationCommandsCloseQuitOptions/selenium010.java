package com.thetestingacademy.ex_selenium.navigationCommandsCloseQuitOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class selenium010 {

    // what is the difference between get amd navigate().to()?

    public static void main(String[] args) throws InterruptedException {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        //driver.get("https://sdet.live");
        // No back, forward allowed in case of get
//        driver.manage().window().maximize();
        driver.navigate().to("https://bing.com");
        driver.navigate().to("https://sdet.live");
        driver.navigate().back();
        driver.navigate().to("https://app.vwo.com");
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();
        Thread.sleep(Long.parseLong("30000"));
    }

}
