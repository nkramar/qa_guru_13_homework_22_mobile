package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserStackConfig extends Config{

  @Key("login")
  String login();

  @Key("password")
  String password();

  @Key("app")
  String app();

  @Key("deviceName")
  String deviceName();

  @Key("osVersion")
  String osVersion();

}


