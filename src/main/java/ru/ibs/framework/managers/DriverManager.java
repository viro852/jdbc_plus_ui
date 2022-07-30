package ru.ibs.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static DriverManager driverManager = null;
    private WebDriver selenDriver = null;

    private ChromeOptions chromeOptions = new ChromeOptions();

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getSelenDriver() {
        if (selenDriver == null) {
            initSelenDriver();
        }
        return selenDriver;
    }

    private void initSelenDriver() {
        //chromeOptions.addArguments("--incognito", "--headless", "--window-size=1920,1080");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        selenDriver = new ChromeDriver();
    }

    public void quitSelenDriver() {
        if (selenDriver != null) {
            selenDriver.quit();
            selenDriver = null;
        }
    }
}
