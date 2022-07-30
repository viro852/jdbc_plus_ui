package ru.ibs.framework.tests;

import org.junit.jupiter.api.Test;
import ru.ibs.framework.BaseTest;
import ru.ibs.framework.pages.StartPage;

public class LoginGitHubTest extends BaseTest {

    @Test
    public void successAuth() {
        pageManager.getPage(StartPage.class)
                .checkOpenPage()
                .clickSignInButton()
                .clickAuthFormSignInButton(1);
    }

    @Test
    public void unsuccessAuth() {
        pageManager.getPage(StartPage.class)
                .checkOpenPage()
                .clickSignInButton()
                .clickAuthFormSignInButton(2);
    }
}
