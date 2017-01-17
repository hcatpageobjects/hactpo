package com.hpe.digitalsafe.Pages.ACModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CreateAuditPage {
	public WebDriver driver;
	public CreateAuditPage(WebDriver localdriver){
		this.driver=localdriver;
	}
    @FindBy(how=How.XPATH, using="//a[contains(.,'Create Audit')]")
	
	WebElement CreateAuditLink;
    
    @FindBy(how=How.ID, using="audit_name")
	
	WebElement AuditNameTextBox;
	
	@FindBy(how=How.ID, using="source")
	
	WebElement SourceTextBox;
	
	@FindBy(how=How.ID, using="requestno")
	
	WebElement RequestNoTextBox;
	
	@FindBy(how=How.ID, using="searchno")
	
	WebElement SearchNoTextBox;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
	
	WebElement NextButtonWithLink;
	
	@FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
	
	WebElement NextButtonOnContent;
	
    @FindBy(how=How.XPATH, using=".//*[@id='AuditCreate_AuditTemplateId']")
	
	WebElement ChooseAuditTemplateDropDown;
	
	
	
	public void Fill_CreateAuditPage(String AuditType, String AuditName) {
		ChooseAuditTemplateDropDown.sendKeys(AuditType);
		ImplWait(5);
		AuditNameTextBox.sendKeys(AuditName);
		NextButtonOnContent.click();
		
		
		
	}
	
	public void ImplWait(int timeinseconds){
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}
}
