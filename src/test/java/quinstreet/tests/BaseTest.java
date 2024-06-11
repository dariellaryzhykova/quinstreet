package quinstreet.tests;

import org.junit.jupiter.api.BeforeAll;
import quinstreet.config.DriverSettings;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    @BeforeAll
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        DriverSettings.configure();
    }
}
