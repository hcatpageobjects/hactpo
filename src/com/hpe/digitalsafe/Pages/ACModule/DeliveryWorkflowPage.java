package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeliveryWorkflowPage {
	public WebDriver driver;
	public DeliveryWorkflowPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_NotificationAddress']")
	WebElement EmailAddressForNotificationDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_OutputFormat']")
	WebElement FormatCheckDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_DeliveryMethod']")
	WebElement DeliveryMethodDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_MaximumFileSize']")
	WebElement MaxFileSizeDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_PauseAfterEstimate']")
	WebElement PauseAfterEstimateCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_RemoveDuplicatesMethod']")
	WebElement RemoveDuplicatesDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_CompressionType']")
	WebElement CompressionTypeDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_AuditPriority']")
	WebElement AuditPriorityDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_Comments']")
	WebElement CommentsTextBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_PauseForReview']")
	WebElement PauseForReviewCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_CreatePreservationPolicy']")
	WebElement CreatePreservationPolicyCheckBox;
	
	@FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
	WebElement NextButtonWithLink;
	
    public void Fill_DeliveryWorkflowPage(String... data) {
    	EmailAddressForNotificationDropDown.sendKeys("");
    	FormatCheckDropDown.sendKeys("");
    	DeliveryMethodDropDown.sendKeys("");
    	MaxFileSizeDropDown.sendKeys("");
    	PauseAfterEstimateCheckBox.click();
    	RemoveDuplicatesDropDown.sendKeys("");
    	CompressionTypeDropDown.sendKeys("");
    	AuditPriorityDropDown.sendKeys("");
    	CommentsTextBox.sendKeys("This is just a comment");
    	PauseForReviewCheckBox.click();
    	CreatePreservationPolicyCheckBox.click();
		NextButtonWithLink.click();
		
	}

}
