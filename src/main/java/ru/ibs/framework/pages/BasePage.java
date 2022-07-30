package ru.ibs.framework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.managers.DBManager;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PageManager;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();

    protected WebDriverWait wait = new WebDriverWait(driverManager.getSelenDriver(), Duration.ofSeconds(10));

    protected PageManager pageManager = PageManager.getPageManager();

    protected DBManager dbManager = DBManager.getDbManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getSelenDriver(), this);
    }

    protected void checkOpenPage(By locator, Class page) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assertions.fail("Страница " + page.getName() + " не загружена!");
        }
    }
}
