package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuditDetailPage {
    WebDriver driver;
	public AuditDetailPage(WebDriver locldriver) {
		this.driver=locldriver;
	}

 @FindBy(how=How.XPATH, using="//a[contains(text(),'Stop')]")
 WebElement StopButton;
 
 @FindBy(how=How.XPATH, using="//a[contains(text(),'Resume')]")
 WebElement ResumeButton;
 
 @FindBy(how=How.XPATH, using="//a[contains(text(),'Print Friendly')]")
 WebElement PrintFriendlyButton;
 
 @FindBy(how=How.XPATH, using="//a[contains(text(),'Save As Template')]")
 WebElement SaveAsTemplateButton;
 
 @FindBy(how=How.ID, using="AuditCreate_DeliveryMethod")
 WebElement DeliveryMethodDropDown;
 
 @FindBy(how=How.NAME, using="AuditCreate_MaximumFileSize")
 WebElement MaximumFileSizeDropDown;
 
 @FindBy(how=How.NAME, using="AuditPriority")
 WebElement AuditPriorityDropDown;
 
 @FindBy(how=How.XPATH, using="//*[@name='select']")
 WebElement CommentsTextBox;
 
 @FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
 WebElement UpdateDeliveryButton;
 
 @FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[2]")
 WebElement UpdatePriorityButton;
 
 public void FillAuditDetailPage(){
	 
	 
	 StopButton.click();
 }
 
 
}
