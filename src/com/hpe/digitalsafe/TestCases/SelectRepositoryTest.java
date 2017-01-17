package com.hpe.digitalsafe.TestCases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeNewSearch;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeTab;

public class SelectRepositoryTest {
	
	
		protected WebDriver driver;
		protected HomePage home_page;
		protected DigitalSafeNewSearch selectRepositories_page;
		protected DigitalSafeTab digitalSafe_tab;
		
		@Test
		@BeforeMethod
		   public void setUp() {
			 driver=BrowserFactory.startBrowserDefault();
				
				//Created page factory to initialize the webelements in the page
				LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
				home_page=PageFactory.initElements(driver, HomePage.class);
				digitalSafe_tab=PageFactory.initElements(driver, DigitalSafeTab.class);
				selectRepositories_page=PageFactory.initElements(driver, DigitalSafeNewSearch.class);
				selectRepositories_page=PageFactory.initElements(driver, DigitalSafeNewSearch.class);
				selectRepositories_page=PageFactory.initElements(driver, DigitalSafeNewSearch.class);
				
				login_page.login_fromPropFile();
				home_page.clickOnTab("DigitalSafeTab");
				digitalSafe_tab.ClickNewSearchLink();
		 }
		  

		   
		@Test(dependsOnMethods="setUp")
		public void searchByCharFilter(){
			
			selectRepositories_page.searchByCharFilter("V");
			
		}
		@Test(dependsOnMethods="setUp")
		public void searchByFiltering(){
			
			selectRepositories_page.searchByFiltering("hello");
			
		}
		
		@Test(dependsOnMethods="setUp")
		public void searchAll(){
			
			selectRepositories_page.searchAll();
		}
		
		@AfterMethod
		   public void tearDown() throws Exception {
			driver.quit();
		   }
		

}
