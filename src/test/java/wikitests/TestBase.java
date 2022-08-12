package wikitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackMobileDriver;
import drivers.EmulatorMobileDriver;
import drivers.RealDeviceDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.WikiAddLanguagesPage;
import pages.WikiOnBoardingPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {
  static String deviceHost = System.getProperty("deviceHost", "emulator");
  WikiOnBoardingPage wikiOnBoardingPage = new WikiOnBoardingPage();
  WikiAddLanguagesPage wikiAddLanguagesPage=new WikiAddLanguagesPage();


  @BeforeAll
  public static void setUp() {
    switch (deviceHost) {
      case "browserstack":
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        break;
      case "realDevice":
        Configuration.browser = RealDeviceDriver.class.getName();
        break;
      case ("emulator"):
      default:
        Configuration.browser = EmulatorMobileDriver.class.getName();
        break;
    }
    Configuration.browserSize = null;
  }

  @BeforeEach
  public void startDriver() {
    addListener("AllureSelenide", new AllureSelenide());
    open();
  }

  @AfterEach
  public void afterEach() {
    String sessionId = sessionId();

    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    step("Close driver", Selenide::closeWebDriver);

    if (deviceHost.equals("browserstack")) {
      Attach.video(sessionId);
    }
  }
}
