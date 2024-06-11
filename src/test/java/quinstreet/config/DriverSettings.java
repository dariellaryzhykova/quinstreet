package quinstreet.config;
import com.codeborne.selenide.Configuration;

public class DriverSettings {
    public static void configure() {
        Configuration.browser = GeneralConfigImpl.config.browser();
        Configuration.browserVersion = GeneralConfigImpl.config.browserVersion();
        Configuration.browserSize = GeneralConfigImpl.config.browserSize();
        //Configuration.headless = false;
    }
}
