package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='login_field']")
    WebElement userNameInput;

    @Step("Клик по кнопке [Sign in] на LoginPage")
    public PersonalPage clickAuthFormSignInButton(int userId) {
        String login = null;
        String password = null;

        try (Connection conn = dbManager.getConnectionToDB();
             PreparedStatement preparedStatement = conn.prepareStatement("select email,password from users_credentials where id=?");
        ) {

            preparedStatement.setInt(1, userId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                login = rs.getString("email");
                password = rs.getString("password");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        userNameInput.sendKeys(login + Keys.TAB);
        driverManager.getSelenDriver().switchTo().activeElement().sendKeys(password + Keys.TAB);
        driverManager.getSelenDriver().switchTo().activeElement().sendKeys(Keys.RETURN);

        if (userId == 1) {
            return pageManager.getPage(PersonalPage.class).checkOpenPage();
        } else {
            Assertions.assertTrue(
                    driverManager.getSelenDriver().findElement(
                            By.xpath("//div[@class='flash flash-full flash-error ']")
                    ).isDisplayed()
            );

            Assertions.assertEquals(
                    "Incorrect username or password.",
                    driverManager.getSelenDriver().findElement(
                            By.xpath("//div[@class='flash flash-full flash-error ']")
                    ).getAttribute("innerText").trim(),
                    "Текст ошибки не соответствует ожидаемому!");
        }
        return null;
    }

    public LoginPage checkOpenPage() {
        super.checkOpenPage(By.xpath("//input[@type='submit']"), LoginPage.class);
        return this;
    }
}
