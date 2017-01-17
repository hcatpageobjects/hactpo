package com.hpe.digitalsafe.Pages.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdministrationTab {

public WebDriver driver;
	
	public AdministrationTab(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'User Management')]")
	
	WebElement UserManagementLink;
	
	public void ClickUserManagementLink(){
		UserManagementLink.click();
	}
	
}
