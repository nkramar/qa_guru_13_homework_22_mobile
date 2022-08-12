package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());
        String login = config.login();
        String password = config.password();
        String app = config.app();
        String deviceName= config.deviceName();
        String osVersion= config.osVersion();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", login);
        mutableCapabilities.setCapability("browserstack.key", password);
        mutableCapabilities.setCapability("app", app);
        mutableCapabilities.setCapability("device", deviceName);
        mutableCapabilities.setCapability("os_version", osVersion);
        mutableCapabilities.setCapability("project", "Home work qa_guru lesson 22");
        mutableCapabilities.setCapability("build", "browserstack-build-2");
        mutableCapabilities.setCapability("name", "Lesson 22");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

