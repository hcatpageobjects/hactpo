package com.hpe.digitalsafe.Pages.DSDiscoveryModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdministrationTab {

public WebDriver driver;
	
	public AdministrationTab(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Retention Policies')]")
	
	WebElement RetentionPoliciesLink;
	
	public void ClickRetentionPoliciesLink(){
		RetentionPoliciesLink.click();
	}
	
}
