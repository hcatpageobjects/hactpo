package com.hpe.digitalsafe.TestCases.DSD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;
import com.hpe.digitalsafe.Pages.DSDiscoveryModule.CreateCasePage;
import com.hpe.digitalsafe.Pages.DSDiscoveryModule.DSD_Tabs;

public class DSD_CreateCaseTests {

	protected WebDriver driver;
	protected HomePage home_page;
	protected DSD_Tabs DSD_Tab;

	protected CreateCasePage create_case;
	@BeforeSuite
	public void suiteSetup1() {
	
	        System.out.println("testClass1.suiteSetup1: before suite");
	
	    } 
	
	
	@BeforeMethod
	 public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			home_page=PageFactory.initElements(driver, HomePage.class);
			DSD_Tab=PageFactory.initElements(driver, DSD_Tabs.class);
			create_case=PageFactory.initElements(driver, CreateCasePage.class);
		
			login_page.login_fromPropFile();
			home_page.clickOnTab("DSDiscoveryTab");
	 }
	   
	@Test
	public void EditCase() {
		 System.out.println("Running Edit CAse");
		 WebDriverWait wait = new WebDriverWait(driver,40);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Case')]")));
	    element.click();
	    WebDriverWait wait1 = new WebDriverWait(driver,10);
	    WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
	    create_case.Fill_CreateCase("venu_2", "venu_2", "venu_2");
		
		//AuditManagementHome_page.ClickAuditName("yyyy");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	   }

}
