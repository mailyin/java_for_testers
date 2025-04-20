package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    public WebDriver driverr;
    private LoginHelper sessionn;
    private GroupHelper groupss;
    private ContactHelper contactt;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;
    private Properties propertiess;

    public void  init(String browser, Properties propertiess) {
        this.propertiess = propertiess;
        if (driverr == null) {
            if ("firefox".equals(browser)) {
                driverr = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                driverr = new ChromeDriver();
            } else {
                throw new IllegalArgumentException(String.format("Неизвестный браузер %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driverr::quit));
            driverr.get(propertiess.getProperty("web.baseUrl"));
            driverr.manage().window().setSize(new Dimension(
                    Integer.parseInt(propertiess.getProperty("web.dimensionWidth")),
                    Integer.parseInt(propertiess.getProperty("web.dimensionHeight"))));
            driverr.findElement(By.name("user")).click();
            session().loginn(propertiess.getProperty("web.username"), propertiess.getProperty("web.password"));
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

    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }

    public HibernateHelper hbm() {
        if (hbm == null) {
            hbm = new HibernateHelper(this);
        }
        return hbm;
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
