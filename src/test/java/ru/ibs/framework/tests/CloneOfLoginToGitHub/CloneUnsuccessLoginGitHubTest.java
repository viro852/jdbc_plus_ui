package ru.ibs.framework.tests.CloneOfLoginToGitHub;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ibs.framework.BaseTest;
import ru.ibs.framework.pages.StartPage;
@Tag("Clone")
@Tag("test-clone2")
@Tag("Regression")
public class CloneUnsuccessLoginGitHubTest extends BaseTest {

    @Test
    @DisplayName("Клон тест на неудачную регистрацию")
    public void unsuccessAuth() {
        pageManager.getPage(StartPage.class)
                .checkOpenPage()
                .clickSignInButton()
                .clickAuthFormSignInButton(2);
    }
}
