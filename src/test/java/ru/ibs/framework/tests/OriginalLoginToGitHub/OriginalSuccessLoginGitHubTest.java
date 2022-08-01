package ru.ibs.framework.tests.OriginalLoginToGitHub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ibs.framework.BaseTest;
import ru.ibs.framework.pages.StartPage;
@Tag("Original")
@Tag("test-orig1")
@Tag("Regression")
public class OriginalSuccessLoginGitHubTest extends BaseTest {

    @Test
    @DisplayName("Оригинал тест на удачную регистрацию")
    public void successAuth() {
        pageManager.getPage(StartPage.class)
                .checkOpenPage()
                .clickSignInButton()
                .clickAuthFormSignInButton(1);
    }
}
