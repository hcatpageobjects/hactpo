package com.hpe.digitalsafe.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;

//@ContextConfiguration(locations = "/SpringConfig.xml")
public class VerifyValidLogin {

	public VerifyValidLogin() {
		
	}
	
	//@Autowired
	protected WebDriver driver;
	protected HomePage home_page;
	 
	/*@BeforeMethod
	 public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			login_page.login_fromPropFile();
	 }
	  */
	
	@Test(invocationCount = 1)
	 public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			login_page.login_fromPropFile();
			String Actualtext = driver.findElement(By.xpath("//a[contains(.,'User Management')]")).getText(); 
			Assert.assertEquals(Actualtext, "User Management"); 
	 }

	   
	@Test(dependsOnMethods = { "setUp" })
	public void checkValidUser(){
		
		home_page=PageFactory.initElements(driver, HomePage.class);
		home_page.clickOnTab("RetentionManagementTab");

	}
	
	@AfterMethod
	   public void tearDown(ITestResult result) throws Exception {
		if(!result.isSuccess()){
			File imageFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String failureImageFileName=result.getMethod().getMethodName()+new SimpleDateFormat("MM-dd-yyyy_MM-ss").format(new GregorianCalendar().getTime())+".png";
			File failureImageFile=new File(failureImageFileName);
			FileUtils.moveFile(imageFile, failureImageFile);
		}
			
		//home_page.logout();
		driver.close();
		driver.quit();
	   }
	

}
