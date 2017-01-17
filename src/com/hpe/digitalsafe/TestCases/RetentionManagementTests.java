package com.hpe.digitalsafe.TestCases;

import java.lang.annotation.RetentionPolicy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hpe.digitalsafe.Helper.BrowserFactory;
import com.hpe.digitalsafe.Pages.Commons.HomePage;
import com.hpe.digitalsafe.Pages.Commons.LoginPage;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeNewSearch;
import com.hpe.digitalsafe.Pages.DSDModule.DigitalSafeTab;
import com.hpe.digitalsafe.Pages.RMModule.CreateDeletionPolicyPage;
import com.hpe.digitalsafe.Pages.RMModule.CreateRetentionPolicyPage;
import com.hpe.digitalsafe.Pages.RMModule.DeletionPoliciesPage;
import com.hpe.digitalsafe.Pages.RMModule.RetentionManagementTab;
import com.hpe.digitalsafe.Pages.RMModule.RetentionPoliciesPage;

public class RetentionManagementTests {
	
	protected WebDriver driver;
	protected HomePage home_page;
	protected RetentionManagementTab RetentionManagement_page;
	protected RetentionPoliciesPage RetentionPolicies_page;
	protected DeletionPoliciesPage DeletionPolicies_page;
	protected CreateRetentionPolicyPage NewRetentionPolicy_page;
	protected CreateDeletionPolicyPage NewDeletionPolicy_page;
	
	@Test
	@BeforeMethod
	   public void setUp() {
		 driver=BrowserFactory.startBrowserDefault();
			
			LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
			home_page=PageFactory.initElements(driver, HomePage.class);
			RetentionManagement_page=PageFactory.initElements(driver, RetentionManagementTab.class);
			RetentionPolicies_page=PageFactory.initElements(driver, RetentionPoliciesPage.class);
			NewRetentionPolicy_page=PageFactory.initElements(driver, CreateRetentionPolicyPage.class);
			NewDeletionPolicy_page=PageFactory.initElements(driver, CreateDeletionPolicyPage.class);
			DeletionPolicies_page=PageFactory.initElements(driver, DeletionPoliciesPage.class);
			
			login_page.login_fromPropFile();
			home_page.clickOnTab("RetentionManagementTab");
	 }
	  

	   
	@Test(priority=1, groups={"sanity"},dependsOnMethods="setUp")
	public void CreateFreshRetentionPolicy(){
		RetentionManagement_page.ClickRetentionPoliciesLink();
		RetentionPolicies_page.Fill_NewActivePreservationPolicyPage();
		NewRetentionPolicy_page.Fill_NewRetentionPolicyForm("New Policy1", "This is just a description", "check");
		
		
	}
	
	@Test(priority=2, groups="sanity",dependsOnMethods={"CreateFreshRetentionPolicy","setUp"})
	public void EditRetentionPolicy(){
		RetentionManagement_page.ClickRetentionPoliciesLink();
		RetentionPolicies_page.Filter_EditActivePreservationPolicyPage("Audit Policy");
		
		
	}
	
	@Test(priority=4, groups="regression", dependsOnMethods={"CreateFreshRetentionPolicy","setUp"})
	public void DeleteRetentionPolicy(){
		RetentionManagement_page.ClickRetentionPoliciesLink();
		RetentionPolicies_page.Filter_DeleteActivePreservationPolicyPage("Audit Policy");
		
		
	}
	
	@Test(priority=3, groups="sanity")
		public void CreateFreshDeletionPolicy() {
			RetentionManagement_page.ClickDeletionPoliciesLink();
			DeletionPolicies_page.Fill_NewActiveDeletionPolicy();
			NewDeletionPolicy_page.Fill_NewDeletionPolicyForm("New Deletion Policy1", "This is just a description", "check");
			
			
		}
		
	@Test(priority=5, groups="sanity",dependsOnMethods={"CreateFreshDeletionPolicy","setUp"})
		public void EditDeletionPolicy(){
			RetentionManagement_page.ClickDeletionPoliciesLink();
			DeletionPolicies_page.Filter_EditActiveDeletionPolicy("DelPolicyNew");
			
			
		}
	
	@Test(priority=6, groups="sanity",dependsOnMethods={"CreateFreshDeletionPolicy","setUp"})
	public void RemoveDeletionPolicy(){
		RetentionManagement_page.ClickDeletionPoliciesLink();
		DeletionPolicies_page.Filter_DeactivateActiveDeletionPolicy("New Deletion Policy1");
		
		
	}
	
	@AfterMethod
	   public void tearDown() throws Exception {
		driver.quit();
	   }

}
