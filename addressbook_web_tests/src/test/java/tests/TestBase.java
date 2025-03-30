package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    protected static ApplicationManager appp;

    @BeforeEach
    public void setUp() {
        if (appp == null) {
            appp = new ApplicationManager();
        }
        appp.init(System.getProperty("browser", "firefox"));
    }
}

