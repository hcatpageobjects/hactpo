package com.hpe.digitalsafe.Pages.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserListPage {
    public WebDriver driver;
    
	public UserListPage(WebDriver localdriver) {
     this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="edit_user")
	WebElement EditButton;
	
	@FindBy(how=How.XPATH, using=".//*[@id='contentPane']/span[2]/a/img")
	WebElement ResetPasswordButton;
	
	

}
