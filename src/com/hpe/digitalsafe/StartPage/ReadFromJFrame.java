package com.hpe.digitalsafe.StartPage;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.excelant.util.ExcelAntEvaluationResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.hpe.digitalsafe.Helper.ModelProperties;
import com.hpe.digitalsafe.TestCases.VerifyValidLogin;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;;



/**
 * ReadFromJgrame: 
 * Creates the main frame.
 * Invokes class-methods to read from the clients information excel sheet.
 * Invokes class-methods to overwrite properties file.
 */

public class ReadFromJFrame extends JFrame implements  ActionListener  {
	

	private static final long serialVersionUID = -981233602929374319L;
	
	private String ticketNumber;
	private String clientName;
	private String browserName;
	private String sendEmailOption;
	private JFrame mainFrame;
	private boolean flag;
	
	private JTextField textTicket = new JTextField(10);
	private JComboBox<String> selectClient = new JComboBox<String>();
	public Vector<String> v = new Vector<String>();
	public JComboBox<String> selectBrowser = new JComboBox<String>(v);
	public JCheckBox sendEmail=new JCheckBox();
	
	private JLabel ticketLabel = new JLabel("Enter Ticket Number:");
	private JLabel selectLabel=new JLabel("Select Client:");
	private JLabel selectBrowserLabel=new JLabel("Select Browser:");
	private JLabel setSendEmail=new JLabel("Send Email:");
	private JButton runButton = new JButton("Run Test");
	private JButton cancelButton= new JButton("Stop Test");
	
	private HashMap<String, Integer> displayClientsList= new HashMap<String, Integer>();
	private HashMap<String, String> clientRowInformation;
	private ReadfromExcel excelObject;
	
	
	private SwingWorker<Void, Void> myWorker;

	/**
	 * constructor
	 */
	public ReadFromJFrame(HashMap<String, Integer> hashMap, ReadfromExcel excelObject1 ){
		super("iSTF Framework 1.1");
		this.displayClientsList=hashMap;
		this.excelObject=excelObject1;
		mainFrame = new JFrame("iSTF Framework 1.1");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(500,200);
		mainFrame.setResizable(false);
		//frame1.setLayout(new FlowLayout());
		mainFrame.setLayout(new GridLayout(5,2));		
	}
	
	
	/**
	* starMainWindow(): initializes, and displays the main JFrame window, 
	* sets layout and shows buttons 
	*/
	public void setMainFrame() {
		//sets the actionPerform thread to the element
		textTicket.addActionListener(this);
		selectClient.addActionListener(this);
		selectBrowser.addActionListener(this);
		runButton.addActionListener(this);
		runButton.setEnabled(true);
		cancelButton.addActionListener(this);
		sendEmail.setSelected(true);
		
		//sets the client list names in the Combo box
		initCombo(selectClient);
		v.addElement("Firefox");
		v.addElement("Chrome");
		v.addElement("IE");
		selectBrowser.setSelectedIndex(0);
		
		//adds each element to be displayed in the frame
		mainFrame.add(ticketLabel);		
		mainFrame.add(textTicket);	
		mainFrame.add(selectLabel);
		mainFrame.add(selectClient);
		mainFrame.add(selectBrowserLabel);
		mainFrame.add(selectBrowser);
		mainFrame.add(setSendEmail);
		mainFrame.add(sendEmail);
		mainFrame.add(cancelButton);
		mainFrame.add(runButton);			
		mainFrame.setVisible(true);
		
		//new JComboBox(Vector);

		

	}
	
	/**
	 * Setters and Getters
	 */
	
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setSelectBrowser(JComboBox<String> selectBrowser) {
		
		try {
			this.browserName = selectBrowser.getSelectedItem().toString();
		} catch (Exception e) {
			this.browserName="Chrome";
		}
	}
	public String getSelectBrowser() {
		return browserName;
	}


	private void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	private void setSendEmail(JCheckBox sendEmail) {
		if (sendEmail.isSelected()) {
			this.sendEmailOption = "true";
		}
		else {
			this.sendEmailOption = "false";
		}
				
	}

	public String getClientName() {
		return this.clientName;
	}

	private void setClientName(String name) {
		this.clientName = name;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	/**
	 * ActionPerformed method; called when clicking a button on the Main Frame
	 */
	@Override
	public  void actionPerformed(ActionEvent e) {
		//String name= e.getActionCommand(); in order to use this, set buttonx.actionActionCommand("xxx")
		
		if (e.getSource() == runButton) {  		// "Run Test" button
			//create method that calls the action to create the properties file
			
			setTicketNumber(textTicket.getText());
			setClientName((String) selectClient.getSelectedItem());
			setSelectBrowser(selectBrowser);
			setSendEmail(sendEmail);
			runBuildPropertiesExecution();			
        }
		if(e.getSource()== cancelButton){ 		//"Cancel" button
			stopExecution();
		}
	}	
	
	/**
	 * calls different methods to build the properties file and execute tests
	 * implements the SwingWorker thread in order to obtain a status when task is done
	 */
	public void runBuildPropertiesExecution(){
		//thread of type SwingWorker		
		 myWorker=new SwingWorker<Void, Void>() {
			
			@Override
			protected Void doInBackground() throws Exception {
				runButton.setEnabled(false);
				System.out.println("runBuildPopertiesExec");
				buildPropertiesfile();  	//builds the PropertiesFile for a specific Client
				//runTestngSuite();
				runNew();
				//starts runTestngSuite execution
				
				return null;
			}

			@Override
			protected void done() {
				super.done();
				
				setFlag(true);
				runButton.setEnabled(true);
			}			
		};		
		myWorker.execute();
	}
	
	public void stopExecution(){		
		System.exit(NORMAL);		
	}

	private void getClientInformation(){			
		clientRowInformation=excelObject.getClientRowInformation(clientName);
		
		if(excelObject.getEmtpyCell()){
			System.out.println(excelObject.getEmtpyCell());
			ErrorJFrame rowError = new ErrorJFrame();
			rowError.displayErrorMessageEmptycell();
			System.exit(0);
		}		
		excelObject.closeConnection();
	}
	
	public void initCombo(JComboBox<String> selectClient){	
		Set<String> keys = displayClientsList.keySet();			
		for(String key:keys){			
//			System.out.println("key name: "+key);
			selectClient.addItem(key.toString());
		}		
	}
	
	public void buildPropertiesfile() {
		
		getClientInformation();	  				//gets client Row information
		
		PropertiesFileTXT myProperties = new PropertiesFileTXT();
	
		try {
			myProperties.createPropertiesFile(clientRowInformation, ticketNumber, browserName, sendEmailOption);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void runTestngSuite() throws IOException{
		//TestngSuite mytestngSuite = new TestngSuite();
		//mytestngSuite.run();
	}
	public void runNew() throws IOException{
		/*setReadExcel();		
		setListNames();
		
		if(getDuplicateclients()){
			startPopupErrorWindow();
		}else{
			startWindowframe();	
		}*/
		
		com.hpe.digitalsafe.Helper.ModelProperties modelproperties=new com.hpe.digitalsafe.Helper.ModelProperties();
		String email=modelproperties.getProperty("EMAILS");
        String ticket=modelproperties.getProperty("Ticket-no");
        String sendemail=modelproperties.getProperty("SENDEMAIL");
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
		suitesList.add("config/TestSuites/"+testsuites.getProperty("JELLY_TESTS_LOCATION"));
		testng.setTestSuites(suitesList);
		testng.addListener(listener);
		testng.run();
		if (!sendemail.equalsIgnoreCase("false")) {
     	   CleanUpReportDirectory();
     	   CopyDirectory();
     	   sendEmail(email, email,ticket);
		}else {
			 CleanUpReportDirectory();
			System.out.println("No Email will be sent with the report!!! ");
		}
 
	}
	
	public void sendEmail(String to, String from, String ticket) throws IOException{
        // Recipient's email ID needs to be mentioned.
        String toEmailID = to;

        // Sender's email ID needs to be mentioned
        String fromEmailID = from;

        // Assuming you are sending email from localhost
        String hostID = "localhost";
        
        //Sending the subject as the ticket number
        String subject=ticket;

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", "smtp.hpe.com");
        properties.setProperty("port", "25");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(fromEmailID));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmailID));

           // Set Subject: header field
           message.setSubject(subject);
           //message.setSubject("This is the Subject Line !");

           // Now set the actual message
           message.setText("This is actual message");
           
           //message ATTACHMENT****************
           // Create the message part
           BodyPart messageBodyPart = new MimeBodyPart();

           // Now set the actual message
           messageBodyPart.setText("This is message body");

           // Create a multipar message
           Multipart multipart = new MimeMultipart();

           // Set text message part
           multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
           messageBodyPart = new MimeBodyPart();
           ZipResultEmailAttachmentNew();
           String filename = "Reports.zip";
           DataSource source = new FileDataSource(filename);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(source.getName());
           multipart.addBodyPart(messageBodyPart);

           // Send the complete message parts
           message.setContent(multipart);
         //message ATTACHMENT****************
           

           // Send message
           System.out.println("Sending Email Please wait....");
           Transport.send(message);
           System.out.println("Sent Email Successfully....");
           DeleteLatestReportDirectory();
        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
      }

	public void CopyDirectory() throws IOException{
    	Path parentFolder = Paths.get("ATU Reports/Results");
		Optional<File> mostRecentFolder =
			    Arrays
			        .stream(parentFolder.toFile().listFiles())
			        .filter(f -> f.isDirectory())
			        .max(
			            (f1, f2) -> Long.compare(f1.lastModified(),
			                f2.lastModified()));
		File srcDir = new File(mostRecentFolder.get().getAbsolutePath());
		File destDir = new File("Reports/Results");
		FileUtils.copyDirectoryToDirectory(srcDir, destDir);
    }
    
    public void DeleteLatestReportDirectory() throws IOException{
    	Path parentFolderNew = Paths.get("Reports/Results");
		Optional<File> mostRecentFolder =
			    Arrays
			        .stream(parentFolderNew.toFile().listFiles())
			        .filter(f -> f.isDirectory())
			        .max(
			            (f1, f2) -> Long.compare(f1.lastModified(),
			                f2.lastModified()));
		File srcDir = new File(mostRecentFolder.get().getAbsolutePath());
		if (srcDir.exists()) {
			FileUtils.deleteDirectory(srcDir);
		
            }
    }
    public void CleanUpReportDirectory() throws IOException{
    	File index = new File("Reports/Results");		
    	FileUtils.cleanDirectory(index);
    }
    
    

    public static void ZipResultEmailAttachmentNew()
    {
     com.hpe.digitalsafe.utils.ZipUtils appZip = new com.hpe.digitalsafe.utils.ZipUtils();
     appZip.CreateZipFile("Reports", "Reports.zip");
    }

	
}


