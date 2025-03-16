import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupRemovingTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1920, 1040));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    @AfterEach
    public void tearDown() {
        //driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    @Test
    public void canRemoveGroup() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.xpath("(//input[@name=\'delete\'])[2]")).click();
    }
}
