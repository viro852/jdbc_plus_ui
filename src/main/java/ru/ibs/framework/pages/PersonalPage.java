package ru.ibs.framework.pages;

import org.openqa.selenium.By;

public class PersonalPage extends BasePage {

    public PersonalPage checkOpenPage() {
        super.checkOpenPage(By.xpath("//a[@aria-label='Pull requests you created']"), PersonalPage.class);
        return this;
    }
}
