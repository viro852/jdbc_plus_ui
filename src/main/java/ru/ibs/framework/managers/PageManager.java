package ru.ibs.framework.managers;

import ru.ibs.framework.pages.BasePage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class PageManager {
    private static PageManager pageManager = null;

    private HashMap<String, BasePage> pagesBox = new HashMap<>();

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public <T extends BasePage> T getPage(Class<T> clazz) {
        if (pagesBox.isEmpty() || pagesBox.get(clazz.getName()) == null) {
            try {
                pagesBox.put(clazz.getName(), clazz.getDeclaredConstructor().newInstance());
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) pagesBox.get(clazz.getName());
    }

    public void clearPagesBox() {
        if (pagesBox != null) {
            pagesBox.clear();
        }
    }
}
