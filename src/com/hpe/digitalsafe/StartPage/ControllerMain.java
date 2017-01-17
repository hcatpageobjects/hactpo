package com.hpe.digitalsafe.StartPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.SwingUtilities;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.hpe.digitalsafe.Helper.ModelProperties;
import com.hpe.digitalsafe.Helper.ReadProperties;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


public class ControllerMain {
	

	private HashMap<String, Integer> mylistNames;
	private ReadFromJFrame myJframeMain;
	private ReadfromExcel readExcel;
	private final String CLIENT_COLUMNNAME ="client";
	private final String EXCELLOCATION = "config/HPE_ClientList.xlsx";
	private final String SHEETNAME = "Sheet1";
	
	public void setListNames(){
		mylistNames=new HashMap<String, Integer>();
		mylistNames=this.readExcel.getClientsNameList(CLIENT_COLUMNNAME,EXCELLOCATION);
	}
	
	
	public HashMap<String,Integer> getListNames(){
		return mylistNames;
	}
	
	public Boolean getDuplicateclients(){
		return readExcel.getDuplicateClients();
	}
	
	public void setMyJframeMain(){
//		Set<String> keys = mylistNames.keySet();
//		for(String key:keys){System.out.println("controller keys: "+ key);}
		this.myJframeMain =new ReadFromJFrame(this.mylistNames, this.readExcel);	
		
	}
	 	
	public ReadFromJFrame getMyJframeMain() {
		return myJframeMain;
	}

	public void startWindowframe() {
				
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				setMyJframeMain();
				myJframeMain.setMainFrame();
			}
		});		
	}
	
	
	public void startPopupErrorWindow(){
		ErrorJFrame errorMessage=new ErrorJFrame();
		errorMessage.displayErrorMessageDuplicate();
	}
	
	
	public ReadfromExcel getReadExcel() {
		return readExcel;
	}

	public void setReadExcel() {
		this.readExcel = new ReadfromExcel(SHEETNAME, EXCELLOCATION);
	}

	public void run() {		
		
		setReadExcel();		
		setListNames();
		
		if(getDuplicateclients()){
			startPopupErrorWindow();
		}else{
			startWindowframe();	
		}				
	}
	
	public void runNew(){
		com.hpe.digitalsafe.Helper.ModelProperties modelproperties=new com.hpe.digitalsafe.Helper.ModelProperties();
		String email=modelproperties.getProperty("EMAILS");
        String ticket=modelproperties.getProperty("Ticket-no");
		setReadExcel();		
		setListNames();
		
		if(getDuplicateclients()){
			startPopupErrorWindow();
		}else{
			startWindowframe();	
		}
		List<Class> reports = new ArrayList<Class>();
        reports.add(ATUReportsListener.class);
        reports.add(ConfigurationListener.class);
        reports.add(MethodListener.class);
       {
		System.setProperty("atu.reporter.config", "config/Atu.properties");
	   }
		List<String> suitesList = new ArrayList<String>();
		TestListenerAdapter listener = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setOutputDirectory("outputfoldername");
		ModelProperties testsuites=new ModelProperties();
		//suitesList.add("config/TestSuites/AllModulesSuites.xml");
		System.out.println("TESTconfig/TestSuites/"+testsuites.getProperty("JELLY_TESTS_LOCATION"));
		suitesList.add("config/TestSuites/SomeModulesSuites.xml"+testsuites.getProperty("JELLY_TESTS_LOCATION"));
		testng.setTestSuites(suitesList);
		testng.addListener(listener);
		testng.run();
 
	}
	
	public static void main(String[] args){		
		ControllerMain myController = new ControllerMain();
		myController.run();
		//myController.runNew();
	}
	
}

