package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    public WebDriver driverr;
    private LoginHelper sessionn;
    private GroupHelper groupss;
    private ContactHelper contactt;

    public void init(String browser) {
        if (driverr == null) {
            if ("firefox".equals(browser)) {
                driverr = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driverr = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driverr::quit));
            driverr.get("http://localhost/addressbook/");
            driverr.manage().window().setSize(new Dimension(1936, 1056));
            driverr.findElement(By.name("user")).click();
            session().loginn("admin", "secret");
        }
    }

    public LoginHelper session() {
        if (sessionn == null) {
            sessionn = new LoginHelper(this);
        }
        return sessionn;
    }

    public GroupHelper groups() {
        if (groupss == null) {
            groupss = new GroupHelper(this);
        }
        return groupss;
    }

    public ContactHelper contacts() {
        if (contactt == null) {
            contactt = new ContactHelper(this);
        }
        return contactt;
    }

    public boolean isElementPresent(By locator) {
        try {
            driverr.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
