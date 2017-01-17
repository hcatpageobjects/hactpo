package com.hpe.digitalsafe.zippy.utils;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;
import java.util.logging.Logger;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

public class GlobalObjects
{
  public static RemoteControlConfiguration rc = null;
  public static SeleniumServer server = null;
  public static HttpCommandProcessor proc = null;
  public static Logger logger = Logger.getLogger("Error Log");
  protected DefaultSelenium helper = null;
  public static AppConfig config = null;
  
  public DefaultSelenium getHelper()
  {
    return this.helper;
  }
  
  public void setHelper(DefaultSelenium helper)
  {
    this.helper = helper;
  }
  
  public static AppConfig getConfig()
  {
    if (config == null) {
      config = new AppConfig();
    }
    return config;
  }
  
  public static void setConfig(AppConfig configname)
  {
    config = configname;
  }
}
