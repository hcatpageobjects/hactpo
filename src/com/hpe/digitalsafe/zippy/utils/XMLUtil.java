package com.hpe.digitalsafe.zippy.utils;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hpe.digitalsafe.zippy.utils.AppConfig;
import com.hpe.digitalsafe.zippy.utils.GlobalObjects;
import com.hpe.digitalsafe.zippy.utils.TableObject;
import com.hpe.digitalsafe.zippy.utils.UIObject;
import com.hpe.digitalsafe.zippy.utils.UIObjectFactory;

public class XMLUtil
{
  private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  private static DocumentBuilder db;
  
  private static Document getDocument(String xml)
  {
    Document doc = null;
    try
    {
      dbf.setNamespaceAware(true);
      db = dbf.newDocumentBuilder();
      doc = db.parse("config/" + xml);
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return doc;
  }
  
  public static UIObject getUIObject(String name)
  {
    try
    {
      Document uimap = getDocument(GlobalObjects.getConfig().getPagesXml());
      
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      
      XPathExpression expr = xpath.compile("//uiobject[@name='" + name + "']");
      Object uiobjectresult = expr.evaluate(uimap, XPathConstants.NODE);
      Node uiobjectresultList = (Node)uiobjectresult;
      if (uiobjectresultList != null)
      {
        Element uiobject = (Element)uiobjectresultList;
        return 
          UIObjectFactory.getUIObject(uiobject.getAttribute("name"), uiobject.getAttribute("type"), uiobject.getTextContent().trim());
      }
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static TableObject getTableUIObject(String name)
  {
    try
    {
      Document uimap = getDocument(GlobalObjects.getConfig().getPagesXml());
      
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      
      XPathExpression expr = xpath.compile("//table[@name='" + name + "']");
      Object tableobjectresult = expr.evaluate(uimap, XPathConstants.NODE);
      Node tableobjectresultList = (Node)tableobjectresult;
      if (tableobjectresultList != null)
      {
        Element tableobject = (Element)tableobjectresultList;
        TableObject tab = new TableObject();
        tab.setName(name);
        NodeList nl = tableobject.getChildNodes();
        Element locatorElement = (Element)nl.item(1);
        tab.setLocator(locatorElement.getTextContent());
        nl = tableobject.getElementsByTagName("uiobject");
        UIObject[] uiobjectarray = null;
        if (nl != null)
        {
          uiobjectarray = new UIObject[nl.getLength()];
          for (int i = 0; i < nl.getLength(); i++)
          {
            Node n = nl.item(i);
            if (n.getNodeType() == 1)
            {
              Element uiobject = (Element)n;
              uiobjectarray[i] = UIObjectFactory.getUIObject(uiobject.getAttribute("name"), uiobject.getAttribute("type"), uiobject.getTextContent().trim());
            }
          }
        }
        tab.setTabuiobject(uiobjectarray);
        return tab;
      }
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  
  public static NodeList getDataList(String data)
  {
    return evaluateXPATH("//data[@name='" + data + "']/properties/*");
  }
  
  public static NodeList getDataList(String category, String data)
  {
    return evaluateXPATH("//category[@name='" + category + "']/data[@name='" + data + "']/properties/*");
  }
  
  public static NodeList getDataSetList(String testCaseID)
  {
    return evaluateXPATH("//testcase[@id='" + testCaseID + "']/dataset");
  }
  
  public static NodeList evaluateXPATH(String xpathstring)
  {
    dbf.setNamespaceAware(true);
    try
    {
      Document datamap = getDocument(GlobalObjects.getConfig().getProjectXml());
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      XPathExpression expr = xpath.compile(xpathstring);
      Object result = expr.evaluate(datamap, XPathConstants.NODESET);
      
      return (NodeList)result;
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}