package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:realDevice.properties"
})
public interface RealDeviceConfig extends Config {

  @Config.Key("platformName")
  String platformName();

  @Config.Key("deviceName")
  String deviceName();

  @Config.Key("osVersion")
  String osVersion();

}
