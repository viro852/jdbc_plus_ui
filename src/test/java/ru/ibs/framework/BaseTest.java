package ru.ibs.framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.InitManager;
import ru.ibs.framework.managers.PageManager;
import ru.ibs.framework.managers.PropManager;
import ru.ibs.framework.utils.PropConsts;

public class BaseTest {

    private DriverManager driverManager = DriverManager.getDriverManager();

    private PropManager propManager = PropManager.getPropManager();

    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeEach
    void setUp() {
        InitManager.startFramework();
        driverManager.getSelenDriver().get(propManager.getProperty(PropConsts.BASE_URL));
    }

    @AfterEach
    void TearDown() {
        InitManager.quitFramework();
    }
}
