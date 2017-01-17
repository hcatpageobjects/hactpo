package com.hpe.digitalsafe.zippy.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hpe.digitalsafe.zippy.utils.XMLUtil;

public class DataObject
{
  private Map<String, String> map;
  
  public DataObject(String path, String key)
  {
    this.map = new LinkedHashMap();
    Element link = null;
    NodeList nodes = XMLUtil.evaluateXPATH(path);
    if ((nodes != null) && (nodes.getLength() > 0))
    {
      for (int i = 0; i < nodes.getLength(); i++)
      {
        link = (Element)nodes.item(i);
        if (link.getAttribute("name").equals(key)) {
          break;
        }
      }
      if (link.getTagName().equals("data")) {
        processDataTag(link);
      } else if (link.getTagName().equals("dataref")) {
        processDataRefTag(link);
      }
    }
  }
  
  private void processDataTag(Element link)
  {
    Node propertiesTag = link.getFirstChild();
    insertIntoMap(propertiesTag.getChildNodes());
  }
  
  private void processDataTag(String str)
  {
    String[] array = str.split("\\.");
    NodeList nodes = XMLUtil.getDataList(array[0], array[1]);
    insertIntoMap(nodes);
  }
  
  private void processDataRefTag(Element link)
  {
    String ref = link.getAttribute("ref");
    processDataTag(ref);
    insertIntoMap(link.getChildNodes());
  }
  
  private void insertIntoMap(NodeList nodes)
  {
    if ((nodes != null) && (nodes.getLength() > 0)) {
      for (int i = 0; i < nodes.getLength(); i++)
      {
        String textcontent = null;
        Node current = nodes.item(i);
        if (current.getNodeType() == 1)
        {
          Element prop = (Element)current;
          if (prop.hasChildNodes()) {
            textcontent = prop.getTextContent();
          }
          this.map.put(prop.getAttribute("name"), textcontent);
        }
      }
    }
  }
  
  public Map<String, String> getMap()
  {
    return this.map;
  }
  
  public void setMap(HashMap<String, String> map)
  {
    this.map = map;
  }
  
  public String get(String key)
  {
    return (String)this.map.get(key);
  }
  
  public Iterator<String> getKeys()
  {
    return getMap().keySet().iterator();
  }
}

