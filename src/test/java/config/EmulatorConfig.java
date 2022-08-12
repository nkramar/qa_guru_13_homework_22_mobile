package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:emulator.properties"
})
public interface EmulatorConfig extends Config {
  @Config.Key("platformNameEm")
  String platformNameEm();

  @Config.Key("deviceNameEm")
  String deviceNameEm();

  @Config.Key("osVersionEm")
  String osVersionEm();

}

