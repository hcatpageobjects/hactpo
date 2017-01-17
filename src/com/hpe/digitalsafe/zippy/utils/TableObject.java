package com.hpe.digitalsafe.zippy.utils;

import com.hpe.digitalsafe.zippy.utils.XMLUtil;
import com.thoughtworks.selenium.DefaultSelenium;

public class TableObject
  extends GlobalObjects
{
  String name;
  UIObject[] tabuiobject;
  String locator;
  
  public TableObject() {}
  
  public TableObject(String tablename, DefaultSelenium selenium)
  {
    TableObject obj = XMLUtil.getTableUIObject(tablename);
    this.name = obj.getName();
    this.locator = obj.getLocator();
    this.tabuiobject = obj.getTabuiobject();
    setHelper(selenium);
    UIObject[] arrayOfUIObject;
    int j = (arrayOfUIObject = this.tabuiobject).length;
    for (int i = 0; i < j; i++)
    {
      UIObject ui = arrayOfUIObject[i];
      ui.setHelper(getHelper());
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getLocator()
  {
    return this.locator;
  }
  
  public void setLocator(String locator)
  {
    this.locator = locator;
  }
  
  public UIObject[] getTabuiobject()
  {
    return this.tabuiobject;
  }
  
  public void setTabuiobject(UIObject[] tabuiobject)
  {
    this.tabuiobject = tabuiobject;
  }
  
  public boolean isElementPresent()
  {
    return this.helper.isElementPresent(this.locator);
  }
}

