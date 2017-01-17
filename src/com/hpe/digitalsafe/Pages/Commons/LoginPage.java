package com.hpe.digitalsafe.Pages.Commons;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.hpe.digitalsafe.Helper.ReadProperties;

public class LoginPage {
	
	public LoginPage(WebDriver webDriver) {
		//super(webDriver);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	Properties globalinfo=ReadProperties.ReadPropeties();
	
	/*public LoginPage(WebDriver localdriver){
		
		this.driver=localdriver;
		
	}*/
   

	@FindBy(how=How.NAME ,using="loginName")
	@CacheLookup
	WebElement userName;
	
	@FindBy(how=How.NAME ,using="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH ,using=".//*[@type='submit']")
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(how=How.XPATH ,using=".//*[@type='reset']")
	@CacheLookup
	WebElement clearButton;
	
	public void login_FromParameters(String username, String password){
		userName.sendKeys(username);
		Password.sendKeys(password);
		submitButton.click();
	}
	
	public void login_fromPropFile(){
		String uid=globalinfo.getProperty("Username");
		String passwd=globalinfo.getProperty("Password");
		userName.sendKeys(uid);
		Password.sendKeys(passwd);
		submitButton.click();
	}
}
