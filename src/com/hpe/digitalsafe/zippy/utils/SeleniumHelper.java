package com.hpe.digitalsafe.zippy.utils;

import com.hpe.digitalsafe.zippy.utils.XMLUtil;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SeleniumHelper
  extends GlobalObjects
{
  public static void startServer()
  {
    rc = new RemoteControlConfiguration();
    rc.setUserExtensions(new File("config/user-extensions.js"));
    rc.setPort(4444);
    try
    {
      server = new SeleniumServer(rc);
      server.boot();
    }
    catch (Exception e)
    {
      logger.log(Level.SEVERE, "Exception while starting selenium server");
      e.printStackTrace();
    }
  }
  
  public static DefaultSelenium setup()
  {
    proc = new HttpCommandProcessor("localhost", 4444, getConfig().getBrowserType(), getConfig().getURL());
    DefaultSelenium helper = null;
    helper = new DefaultSelenium(proc);
    GlobalObjects.logger.log(Level.INFO, "URL=" + getConfig().getURL());
    helper.start();
    helper.open(getConfig().getURL());
    helper.waitForPageToLoad(getConfig().getTimeout());
    helper.setTimeout(getConfig().getTimeout());
    helper.windowMaximize();
    helper.setSpeed("1000");
    helper.useXpathLibrary("javascript-xpath");
    
    return helper;
  }
  
  public static void close(DefaultSelenium helper)
  {
    helper.close();
    helper.stop();
  }
  
  public static void shutdown()
  {
    server.stop();
  }
  
  public void fillForm(String page, String data)
  {
    NodeList nodes = XMLUtil.getDataList(data);
    if ((nodes != null) && (nodes.getLength() > 0)) {
      for (int i = 0; i < nodes.getLength(); i++)
      {
        Element link = (Element)nodes.item(i);
        UIObject ui = getUIObject(link.getAttribute("name"));
        if (ui != null) {
          if (link.hasChildNodes()) {
            ui.write(link.getTextContent());
          } else {
            ui.write(null);
          }
        }
      }
    }
  }
  
  public void fillForm(DataObject data)
  {
    Iterator<String> it = data.getKeys();
    while (it.hasNext())
    {
      String key = (String)it.next();
      fill(data, key);
    }
  }
  
  public void fill(DataObject data, String key)
  {
    UIObject ui = getUIObject(key);
    if (ui != null) {
      ui.write(data.get(key));
    } else {
      System.out.println("UIObject not found");
    }
  }
  
  public boolean isElementPresent(String objName)
  {
    UIObject obj = getUIObject(objName);
    return obj.isElementPresent();
  }
  
  public boolean isTextPresent(String text)
  {
    boolean check = this.helper.isTextPresent(text);
    return check;
  }
  
  public void waitForPageToLoad()
  {
    this.helper.waitForPageToLoad(getConfig().getTimeout());
  }
  
  public void selectFrame(String string)
  {
    UIObject obj = getUIObject(string);
    obj.write(null);
  }
  
  public void clearFrame()
  {
    this.helper.selectWindow(null);
  }
  
  public UIObject getUIObject(String name)
  {
    UIObject ui = XMLUtil.getUIObject(name);
    ui.setHelper(getHelper());
    return ui;
  }
  
  public UIObject getUIObject(String name, String... replace)
  {
    UIObject ui = XMLUtil.getUIObject(name);
    ui.setHelper(getHelper());
    ui.replaceAll(replace);
    return ui;
  }
  
  public void navigateToTab(String key)
  {
    UIObject ui = XMLUtil.getUIObject(key);
    ui.setHelper(getHelper());
    ui.write(null);
  }
  
  public static void main(String[] args)
  {
    SeleniumHelper h = new SeleniumHelper();
    UIObject obj = h.getUIObject("replace");
    obj.replaceString("hello");
    obj.replaceString("bye");
    System.out.println(obj.getLocator());
  }
}

