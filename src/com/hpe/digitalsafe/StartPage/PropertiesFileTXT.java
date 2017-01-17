package com.hpe.digitalsafe.StartPage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JComboBox;




public class PropertiesFileTXT {
	//Column names
	private static final String URL = "url".toLowerCase();
	private static final String CLIENTNAME = "client".toLowerCase();
	private static final String LOGIN = "login".toLowerCase();
	private static final String PASSWORD = "password".toLowerCase();
	private static final String JELLY_TESTCASE_LOCATION = "TestCaseLocation".toLowerCase();
	private static final String BROWSER = "Browser".toLowerCase();
	private static final String EMAIL = "email".toLowerCase();
	private static final String REPOSITORYlOCATION = "repositorylocation".toLowerCase();


	private String propertiesfileLocation="config/AppConfig.properties";
		
	public void createPropertiesFile(HashMap<String, String> clientRow, String ticket, String browserName, String sendemail) throws IOException{
		HashMap<String,String> clientInfo=clientRow;
		clientInfo=clientRow;
		
		String location=clientInfo.get(REPOSITORYlOCATION);
		//System.out.println(location);
		String myurl="URL="+clientInfo.get(URL);
		//System.out.println(myurl);
		String login="Username="+clientInfo.get(LOGIN.toLowerCase());
		//System.out.println(login);
		String password="Password="+clientInfo.get(PASSWORD.toLowerCase());
		String testCaseLocation="JELLY_TESTS_LOCATION="+clientInfo.get(JELLY_TESTCASE_LOCATION);
		//String browser="BROWSER="+clientInfo.get(BROWSER);
		String browser="BROWSER="+browserName;
		String ticketNo="Ticket-no="+ticket;
		String myemail="EMAILS="+clientInfo.get(EMAIL);
		String sendreport="SENDEMAIL="+sendemail;
		
		File properitesFile = new File(propertiesfileLocation);		
		
		BufferedWriter bw= new BufferedWriter(new FileWriter(properitesFile));
		
		
		bw.write(myurl);
		bw.newLine();
		bw.write(login);
		bw.newLine();
		bw.write(password);
		bw.newLine();
		bw.write(ticketNo);
		bw.newLine();
		bw.write("#This Flag will clear all the jelly tests if value is YES . Otherwise it will append.");
		bw.newLine();
		bw.write("CLEAN_JELLY_TESTS=yes");
		bw.newLine();
		bw.write("# Location of the Sqlite DB where Testcases gets Stored ex:C:\\DS\\DS_POC\\DB.dat");
		bw.newLine();
		bw.write("MODEL_DB_LOCATION="+location+"Database\\\\DB_New.dat\\\\");
		bw.newLine();
		bw.write("# Location of the xml file where all the locators are specified for all the elements specified in the model xmls");
		bw.newLine();
		bw.write("OBJECT_REPOSITORY_XML_PATH="+location+"sampleTestCase_ObjectRepo.xml\\\\");
		bw.newLine();
		bw.write("#MODEL_XML_PATH="+location+"MODEL_XML_FILES\\");
		bw.newLine();
		bw.write("TEMP_LOCATION=c:\\\\temp\\\\");
		bw.newLine();
		bw.write(testCaseLocation);
		bw.newLine();
		bw.write("EXEPECTED_RESULTS_DB_LOCATION="+location);
		bw.newLine();
		bw.write("ALM_FORMAT_STORE_LOC="+location+"ALM_Formated_Tests\\\\");
		bw.newLine();
		bw.write(browser);
		bw.newLine();
		bw.write(myemail);
		bw.newLine();
		bw.write(sendreport);
		bw.close();
				
	}
	
}
