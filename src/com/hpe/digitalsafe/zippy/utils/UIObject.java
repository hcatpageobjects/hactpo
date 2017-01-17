package com.hpe.digitalsafe.zippy.utils;

import com.hpe.digitalsafe.zippy.utils.PlaintextUIObject;
import com.thoughtworks.selenium.DefaultSelenium;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UIObject
  extends GlobalObjects
{
  String name;
  String type;
  String locator;
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public String getLocator()
  {
    return this.locator;
  }
  
  public void setLocator(String locator)
  {
    this.locator = locator;
  }
  
  public abstract String read();
  
  public abstract void write(String paramString);
  
  public void write()
  {
    write(null);
  }
  
  public boolean isElementPresent()
  {
    return this.helper.isElementPresent(this.locator);
  }
  
  public String getReplacedString(String str)
  {
    String[] s = str.split(",");
    String loc = getLocator();
    Pattern p = Pattern.compile("\\$\\{(\\w+)\\}");
    Matcher m = p.matcher(loc);
    String[] arrayOfString1;
    int j = (arrayOfString1 = s).length;
    for (int i = 0; i < j; i++)
    {
      String replace = arrayOfString1[i];
      loc = m.replaceFirst(replace);
    }
    return loc;
  }
  
  public void replaceString(String str)
  {
    String[] s = str.split(",");
    String loc = getLocator();
    Pattern p = Pattern.compile("\\$\\{(\\w+)\\}");
    Matcher m = p.matcher(loc);
    String[] arrayOfString1;
    int j = (arrayOfString1 = s).length;
    for (int i = 0; i < j; i++)
    {
      String replace = arrayOfString1[i];
      loc = m.replaceFirst(replace);
    }
    setLocator(loc);
  }
  
  public boolean hasReplaceString()
  {
    return getLocator().indexOf("\\$\\{") != -1;
  }
  
  public void replaceAll(String... replace)
  {
    String loc = getLocator();
    String[] arrayOfString;
    int j = (arrayOfString = replace).length;
    for (int i = 0; i < j; i++)
    {
      String s = arrayOfString[i];
      Pattern p = Pattern.compile("\\$\\{(\\w+)\\}");
      Matcher m = p.matcher(loc);
      loc = m.replaceFirst(s);
    }
    setLocator(loc);
  }
  
  public static void main(String[] args)
  {
    PlaintextUIObject obj = new PlaintextUIObject();
    obj.setLocator("//div[text('${columntext}']/parent:/parent:/descendant::div[text('${value}']");
    obj.replaceAll(new String[] { "Helo", "blah" });
    System.out.println(obj.getLocator());
  }
}
