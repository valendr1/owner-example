package config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${config-test}.properties")
public interface WebDriverConfig extends Config  {

    @Key("browserName")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("91.0")
    String getBrowserVersion();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("remoteUrl")
    URL getRemoteUrl();
}
