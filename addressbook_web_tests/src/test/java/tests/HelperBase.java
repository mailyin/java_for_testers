package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;

public class HelperBase {
    protected final ApplicationManager managerr;

    public HelperBase(ApplicationManager managerr) {
        this.managerr = managerr;
    }

    protected void click(By locatorr) {
        managerr.driverr.findElement(locatorr).click();
    }

    protected void type(By locatorr, String textt) {
        managerr.driverr.findElement(locatorr).clear();
        managerr.driverr.findElement(locatorr).sendKeys(textt);
    }
}
