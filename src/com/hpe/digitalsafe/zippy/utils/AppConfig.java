package com.hpe.digitalsafe.zippy.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AppConfig
{
  private String protocol;
  private String host;
  private String port;
  private String contextroot;
  private String uimappath;
  private String initdatamap;
  private String browserType;
  private String browserVersion;
  private String timeout;
  private String screenshotRequired;
  private String screenshotFolder;
  private String DBDriver;
  private String oracleConnString;
  private String oracleDBUserName;
  private String oracleDBPassword;
  
  public String getOracleConnString()
  {
    return this.oracleConnString;
  }
  
  public void setOracleConnString(String oracleConnString)
  {
    this.oracleConnString = oracleConnString;
  }
  
  public String getOracleDBPassword()
  {
    return this.oracleDBPassword;
  }
  
  public void setOracleDBPassword(String oracleDBPassword)
  {
    this.oracleDBPassword = oracleDBPassword;
  }
  
  public String getOracleDBUserName()
  {
    return this.oracleDBUserName;
  }
  
  public void setOracleDBUserName(String oracleDBUserName)
  {
    this.oracleDBUserName = oracleDBUserName;
  }
  
  public AppConfig()
  {
    generateConfig();
  }
  
  public static void main(String[] args)
  {
    AppConfig a = new AppConfig();
  }
  
  public AppConfig generateConfig()
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    try
    {
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document dom = db.parse("config/AppConfig.xml");
      
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      XPathExpression expr = xpath.compile("//parameters/*/text()");
      Object result = expr.evaluate(dom, XPathConstants.NODESET);
      
      NodeList nodes = (NodeList)result;
      
      this.protocol = nodes.item(0).getNodeValue();
      this.host = nodes.item(1).getNodeValue();
      if (!nodes.item(2).getNodeValue().equals(" ")) {
        this.port = nodes.item(2).getNodeValue();
      }
      if (!nodes.item(3).getNodeValue().equals(" ")) {
        this.contextroot = nodes.item(3).getNodeValue();
      }
      this.uimappath = nodes.item(4).getNodeValue();
      this.initdatamap = nodes.item(5).getNodeValue();
      this.browserType = nodes.item(6).getNodeValue();
      this.browserVersion = nodes.item(7).getNodeValue();
      this.timeout = nodes.item(8).getNodeValue();
      this.screenshotRequired = nodes.item(9).getNodeValue();
      this.screenshotFolder = nodes.item(10).getNodeValue();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public String getHandle()
  {
    return this.contextroot;
  }
  
  public void setHandle(String handle)
  {
    this.contextroot = handle;
  }
  
  public String getProtocol()
  {
    return this.protocol;
  }
  
  public void setProtocol(String protocol)
  {
    this.protocol = protocol;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public void setHost(String host)
  {
    this.host = host;
  }
  
  public String getPort()
  {
    return this.port;
  }
  
  public void setPort(String port)
  {
    this.port = port;
  }
  
  public String getPagesXml()
  {
    return this.uimappath;
  }
  
  public void setPagesXml(String pagesXml)
  {
    this.uimappath = pagesXml;
  }
  
  public String getProjectXml()
  {
    return this.initdatamap;
  }
  
  public void setProjectXml(String projectXml)
  {
    this.initdatamap = projectXml;
  }
  
  public String getBrowserType()
  {
    return this.browserType;
  }
  
  public void setBrowserType(String browserType)
  {
    this.browserType = browserType;
  }
  
  public String getBrowserVersion()
  {
    return this.browserVersion;
  }
  
  public void setBrowserVersion(String browserVersion)
  {
    this.browserVersion = browserVersion;
  }
  
  public String getTimeout()
  {
    return this.timeout;
  }
  
  public void setTimeout(String timeout)
  {
    this.timeout = timeout;
  }
  
  public String getURL()
  {
    return this.protocol + "://" + this.host + (this.port != null ? ":" + this.port : "") + "/" + (this.contextroot != null ? this.contextroot : "");
  }
  
  public void setScreenshotRequired(String screenshotRequired)
  {
    this.screenshotRequired = screenshotRequired;
  }
  
  public String getScreenshotRequired()
  {
    return this.screenshotRequired;
  }
  
  public void setScreenshotFolder(String screenshotFolder)
  {
    this.screenshotFolder = screenshotFolder;
  }
  
  public String getScreenshotFolder()
  {
    return this.screenshotFolder;
  }
}

