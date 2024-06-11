package quinstreet.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/web.properties"
})
public interface GeneralConfig extends Config {

    @Config.Key("browser")
    String browser();

    @Config.Key("browserVersion")
    String browserVersion();

    @Config.Key("browserSize")
    String browserSize();
}
