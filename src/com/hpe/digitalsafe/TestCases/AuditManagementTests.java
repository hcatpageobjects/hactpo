package com.hpe.digitalsafe.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.ACModule.AuditCenterTab;
import com.hpe.digitalsafe.Pages.ACModule.AuditManagementHomePage;
import com.hpe.digitalsafe.Pages.ACModule.ConfirmAndRunPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateAuditPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateQueryPage;
import com.hpe.digitalsafe.Pages.ACModule.CreateSelectCustodiansPage;
import com.hpe.digitalsafe.Pages.ACModule.DeliveryWorkflowPage;
import com.hpe.digitalsafe.Pages.ACModule.PostProcessingPage;
import com.hpe.digitalsafe.Pages.ACModule.SelectDateRangePage;
import com.hpe.digitalsafe.Pages.ACModule.SelectRepositoriesPage;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeTab;
import com.hpe.digitalsafe.zippy.utils.DataObject;
import com.hpe.digitalsafe.zippy.utils.DataSet;
import com.hpe.digitalsafe.zippy.utils.TestCase;

public class AuditManagementTests {

	protected WebDriver driver;
	protected HomePage home_page;
	protected AuditCenterTab auditCenter_Tab;
	protected AuditManagementHomePage AuditManagementHome_page;
	
	@BeforeSuite
	public void suiteSetup1() {
	
	        System.out.println("testClass1.suiteSetup1: before suite");
	
	    } 
	
	@Test
	@BeforeMethod
	 public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			home_page=PageFactory.initElements(driver, HomePage.class);
			auditCenter_Tab=PageFactory.initElements(driver, AuditCenterTab.class);
			AuditManagementHome_page=PageFactory.initElements(driver, AuditManagementHomePage.class);
			login_page.login_fromPropFile();
			home_page.clickOnTab("AuditCenterTab");
	 }
	   
	@Test(dependsOnMethods = { "setUp" })
	public void CreateNewAudit() {
		
		auditCenter_Tab.ClickAuditManagementLink();
		
		AuditManagementHome_page.ClickAuditName("yyyy");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	   }

}
