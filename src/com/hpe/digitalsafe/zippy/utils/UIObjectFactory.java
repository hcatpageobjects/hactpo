package com.hpe.digitalsafe.zippy.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UIObjectFactory
{
  public static UIObject getUIObject(String name, String type, String locator)
  {
    try
    {
      UIObject obj = 
      
        (UIObject)Class.forName("com.cisco.zippy.uiobjects." + capitalize(type) + "UIObject").newInstance();
      
      obj.setName(name);
      obj.setType(type);
      obj.setLocator(locator);
      return obj;
    }
    catch (InstantiationException e)
    {
      GlobalObjects.logger.log(Level.SEVERE, "Unable to instantiate " + capitalize(type) + 
        "UIObject");
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      GlobalObjects.logger.log(Level.SEVERE, "Unable to access " + capitalize(type) + "UIObject");
      e.printStackTrace();
    }
    catch (ClassNotFoundException e)
    {
      GlobalObjects.logger.log(Level.SEVERE, "Unable to find class " + capitalize(type) + 
        "UIObject");
      e.printStackTrace();
    }
    return null;
  }
  
  public static String capitalize(String s)
  {
    s = s.trim();
    if (s.length() == 0) {
      return s;
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }
}
