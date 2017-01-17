package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateQueryPage {
	
	public WebDriver driver;
	public CreateQueryPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_QueryLanguage']")
	
	WebElement QueryLanguageDropDown;
	
    @FindBy(how=How.XPATH, using="//*[@id='AuditCreate_DocumentType']")
	
	WebElement DocumentTypeDropDown;
    
    @FindBy(how=How.XPATH, using="//*[@id='AuditCreate_CriteriaName_0']")
    WebElement CriteriaNameDropDown;
	
    @FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
	
	WebElement NextButtonWithLink;
	
	@FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
	
	WebElement NextButtonOnContent;
    
    
    public void Fill_CreateQueryPage(String language, String doctype, String criteria) {

    	QueryLanguageDropDown.sendKeys(language);
    	DocumentTypeDropDown.sendKeys(doctype);
    	CriteriaNameDropDown.sendKeys(criteria);
    	NextButtonOnContent.click();	
		
		
	}

}
