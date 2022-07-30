package ru.ibs.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;

    @Step("Клик по кнопке [Sign in] на стартовой странице")
    public LoginPage clickSignInButton(){
        signInButton.click();
        return pageManager.getPage(LoginPage.class).checkOpenPage();
    }

    public StartPage checkOpenPage() {
        super.checkOpenPage(By.xpath("//a[contains(text(),'Sign in')]"), StartPage.class);
        return this;
    }
}
