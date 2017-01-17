package com.hpe.digitalsafe.Pages.DSDModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchCriteriaPage {
    
	WebDriver driver;
	public SearchCriteriaPage(WebDriver localdriver) {
		this.driver=localdriver;
	}
	@FindBy(how=How.NAME, using="D_FROM")
	WebElement SenderTextBox;
	
	@FindBy(how=How.NAME, using="D_CC")
	WebElement RecepientTextBox;
	
	@FindBy(how=How.NAME, using="D_SUBJECT")
	WebElement SubjectTextBox;
	
	@FindBy(how=How.NAME, using="D_=BODY=")
	WebElement BodyAttachmentsTextBox;
	
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-SENDER-ID")
	WebElement SenderUIDTextBox;

	@FindBy(how=How.NAME, using="D_=ATTACHMENTNAME=")
	WebElement AttachmentNameTextBox;

	@FindBy(how=How.NAME, using="D_MESSAGE-ID")
	WebElement MessageIDTextBox;
	
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-REGION-CODE")
	WebElement CountryCodeTextBox;
	
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-CONTENT-TYPE")
	WebElement ContentTypeTextBox;
		
	@FindBy(how=How.NAME, using="D_X-BACKUP-DATE")
	WebElement BackUpDateTextBox;
	
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-RECIPIENTS-ID")
	WebElement ReciepientUIDTextBox;
		
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-SENDER-S6-GROUP-ID")
	WebElement SendersS6TextBox;
		
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-SENDER-S6-USER-GROUP-MAPPING")
	WebElement SenderS6GrpMappingTextBox;
		
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-RECIPIENTS-S6-GROUP-ID")
	WebElement ReciepientGrpIDTextBox;
		
	@FindBy(how=How.NAME, using="D_X-ZANTAZ-RECIPIENTS-S6-USER-GROUP-MAPPING")
	WebElement ReciepientGrpMappingTextBox;
		
	@FindBy(how=How.NAME, using="D_SN")
	WebElement SurnameTextBox;
		
	@FindBy(how=How.NAME, using="D_GIVENNAME")
	WebElement GivenNameTextBox;
	
	@FindBy(how=How.NAME, using="D_CN")
	WebElement CommonNameTextBox;
	
	@FindBy(how=How.NAME, using="SEARCH_JUSTIFICATION_PARAM")
	WebElement CommentsTextBox;
	
	@FindBy(how=How.ID, using="amo")
	WebElement StartMonthDropDown;
	
	@FindBy(how=How.NAME, using="ady")
	WebElement StartDayDropDown;
	
	@FindBy(how=How.NAME, using="ady")
	WebElement StartYearDropDown;
	
	@FindBy(how=How.ID, using="ahour")
	WebElement StartHourDropDown;
	
	@FindBy(how=How.NAME, using="amin")
	WebElement StartMinuteDropDown;
	
	@FindBy(how=How.ID, using="bmo")
	WebElement EndMonthDropDown;
	
	@FindBy(how=How.NAME, using="bdy")
	WebElement EndDayDropDown;
	
	@FindBy(how=How.NAME, using="bdy")
	WebElement EndYearDropDown;
	
	@FindBy(how=How.ID, using="bhour")
	WebElement EndHourDropDown;
	
	@FindBy(how=How.NAME, using="bmin")
	WebElement EndMinuteDropDown;
		
	@FindBy(how=How.NAME, using="select1")
	WebElement SearchTipsDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//input[@type='button']")
	WebElement SubmitButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//input[@type='submit']")
	WebElement ClearButton;
		
    public void FillSearchCriteriaPage(String Sender){
    	SenderTextBox.sendKeys(Sender);
    	SubmitButton.click();
    }
}
