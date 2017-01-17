package com.hpe.digitalsafe.zippy.utils;

public class DataSet
extends GlobalObjects
{
private DataObject dataObject;
private String testCaseID;
private String setID;

public DataSet(String testCaseID, String setID)
{
  this.testCaseID = testCaseID;
  this.setID = setID;
}

public DataObject getDataObject(String key)
{
  this.dataObject = new DataObject("//testcase[@id='" + this.testCaseID + "']/dataset[@name='" + this.setID + "']/*[self::data or self::dataref]", key);
  
  return this.dataObject;
}

public DataObject getDataObject()
{
  return this.dataObject;
}

public void setDataObject(DataObject object)
{
  this.dataObject = object;
}

public String getName()
{
  return this.setID;
}

public void setName(String name)
{
  this.setID = name;
}

public String getTestCaseID()
{
  return this.testCaseID;
}

public void setTestCaseID(String testCaseID)
{
  this.testCaseID = testCaseID;
}

public String toString()
{
  return this.testCaseID + ":" + this.setID;
}
}

