package com.thetestingacademy.ex_selenium.navigationCommandsCloseQuitOptions;

import org.openqa.selenium.edge.EdgeDriver;

public class selenium005 {
    public static void main(String[] args) {
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://sdet.live");
        driver.manage().window().maximize();

        driver.quit();
    }

}
