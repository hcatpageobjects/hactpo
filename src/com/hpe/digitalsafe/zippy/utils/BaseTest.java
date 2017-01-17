package com.hpe.digitalsafe.zippy.utils;

import com.hpe.digitalsafe.zippy.utils.XMLUtil;
import com.thoughtworks.selenium.DefaultSelenium;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public abstract class BaseTest
  extends GlobalObjects
{
  private String datamap = null;
  
  public String getDatamap()
  {
    return this.datamap;
  }
  
  public void setDatamap(String datamap)
  {
    this.datamap = datamap;
  }
  
  public BaseTest()
  {
    String className = getClass().getSimpleName();
    
    String module = className.substring(0, className.indexOf("Test"));
    getConfig().setProjectXml("testdata/" + module + "datamap.xml");
    this.datamap = ("testdata/" + module + "datamap.xml");
  }
  
  @BeforeTest(alwaysRun=true)
  public void setUp()
  {
    setHelper(SeleniumHelper.setup());
  }
  
  @AfterTest
  public void tearDown()
    throws IOException
  {
    SeleniumHelper.close(getHelper());
  }
  
  public TestCase getTestCase(Class<?> testClass, String methodname)
  {
    Method method = null;
    try
    {
      method = testClass.getMethod(methodname, new Class[] { DataSet.class });
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchMethodException e)
    {
      e.printStackTrace();
    }
    return (TestCase)method.getAnnotation(TestCase.class);
  }
  
  @DataProvider(name="datasetDataProvider")
  public Iterator<Object[]> configuration(Method method)
  {
    TestCase tc = getTestCase(getClass(), method.getName());
    String classname = getClass().getSimpleName();
    String module = classname.substring(0, classname.indexOf("Test"));
    getConfig().setProjectXml("testdata/" + module + "datamap.xml");
    GlobalObjects.logger.log(Level.INFO, "Testcase ID: " + tc.id() + " Description: " + tc.Description() + " Author: " + tc.Author());
    NodeList nodes = XMLUtil.getDataSetList(tc.id());
    List<Object[]> list = new ArrayList();
    if ((nodes != null) && (nodes.getLength() > 0)) {
      for (int i = 0; i < nodes.getLength(); i++)
      {
        Element link = (Element)nodes.item(i);
        list.add(new Object[] {
          new DataSet(tc.id(), link.getAttribute("name")) });
      }
    }
    return list.iterator();
  }
  
  public void captureScreenshot(String fileName)
    throws IOException
  {
    String base64Screenshot = getHelper().captureScreenshotToString();
    byte[] decodedScreenshot = Base64.decodeBase64(base64Screenshot.getBytes());
    FileOutputStream fos = new FileOutputStream(fileName);
    fos.write(decodedScreenshot);
    fos.close();
  }
}
