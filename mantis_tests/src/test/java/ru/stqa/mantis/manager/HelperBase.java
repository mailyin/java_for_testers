package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locatorr) {
        manager.driver().findElement(locatorr).click();
    }

    protected void type(By locatorr, String text) {
        manager.driver().findElement(locatorr).clear();
        manager.driver().findElement(locatorr).sendKeys(text);
    }

    protected void attach(By locatorr, String file) {
        manager.driver().findElement(locatorr).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected boolean isElementPresent(By locator) {
        return manager.driver().findElements(locator).size() > 0;
    }
}
