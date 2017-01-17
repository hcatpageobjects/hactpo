package com.hpe.digitalsafe.zippy.utils;

import com.hpe.digitalsafe.zippy.utils.UIObject;
import com.thoughtworks.selenium.DefaultSelenium;

public class PlaintextUIObject
  extends UIObject
{
  public String read()
  {
    return this.helper.getText(getLocator());
  }
  
  public void write(String arg0) {}
}