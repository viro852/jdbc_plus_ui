package ru.ibs.framework.managers;

import ru.ibs.framework.utils.PropConsts;

import java.util.concurrent.TimeUnit;

public class InitManager {
    private static InitManager initManager = null;

    private static DriverManager driverManager = DriverManager.getDriverManager();

    private static PropManager propManager = PropManager.getPropManager();

    private static PageManager pageManager = PageManager.getPageManager();

    private InitManager() {

    }

    public static InitManager getInitManager() {
        if (initManager == null) {
            initManager = new InitManager();
        }
        return initManager;
    }

    public static void startFramework() {
        driverManager.getSelenDriver().manage().window().maximize();
        driverManager.getSelenDriver().manage().timeouts().implicitlyWait((Integer.parseInt(propManager.getProperty(PropConsts.IMPLICITLY_WAIT))), TimeUnit.SECONDS);
        driverManager.getSelenDriver().manage().timeouts().pageLoadTimeout((Integer.parseInt(propManager.getProperty(PropConsts.PAGE_LOAD_TIMEOUT))), TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitSelenDriver();
        pageManager.clearPagesBox();
    }
}
