package com.hpe.digitalsafe.Pages.Commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HomePage {
	
	public WebDriver driver;

	public HomePage(WebDriver localdriver) {
     this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Administration')]")
	@CacheLookup
	WebElement AdministrationTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Audit Center')]") 
	@CacheLookup
	WebElement AuditCenterTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'DS Discovery')]")
	@CacheLookup
	WebElement DSDiscoveryTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Digital Safe')]")
	@CacheLookup
	WebElement DigitalSafeTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Retention Management')]")
	@CacheLookup
	WebElement RetentionManagementTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Log Off')]")
	@CacheLookup
	WebElement LogOff;
	
	//@FindBy(how=How.ID, using="new-active-preservation")
	@FindBy(how=How.XPATH, using="//a[contains(.,'Grouping Report')]")
	@CacheLookup
	WebElement ActivePreservationLink;
	
	public void clickOnTab(String tab) {
		
		if(tab.equals("AdministrationTab")){
			AdministrationTab.click();
		}
		else if(tab.equals("AuditCenterTab")){
			AuditCenterTab.click();
		}
		else if(tab.equals("DSDiscoveryTab")){
			DSDiscoveryTab.click();
		}
		else if(tab.equals("DigitalSafeTab")){
			DigitalSafeTab.click();
		}
		else if(tab.equals("RetentionManagementTab")){
			RetentionManagementTab.click();
			Assert.assertEquals(ActivePreservationLink.isDisplayed(), true);
		}
		
	}
	
	public void clickOnWebElement(WebElement wtab){
		wtab.click();
	}
	
	public void logout(){
		
		LogOff.click();
		driver.close();
		
	}
	
	
	

}
