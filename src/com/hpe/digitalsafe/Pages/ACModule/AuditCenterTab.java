package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuditCenterTab {

public WebDriver driver;
	
	public AuditCenterTab(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Audit Management')]")
	
	WebElement AuditManagementLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Create Audit')]")
	
	WebElement CreateAuditLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Manage Custodians')]")
	
	WebElement ManageCustodiansLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Remove Audit Legal Hold')]")
	
	WebElement RemoveAuditLegalHoldLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Current Audit Report')]")
	
	WebElement CurrentAuditReportLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Archived AuditReport Link')]")
	
	WebElement ArchivedAuditReportLinkLink;
	
	
	public void ClickAuditManagementLink(){
		AuditManagementLink.click();
	}
	
	public void ClickCreateAuditLink(){
		CreateAuditLink.click();
	}
	
	public void ClickManageCustodiansLink(){
		ManageCustodiansLink.click();
	}
	
	public void ClickRemoveAuditLegalHoldLink(){
		RemoveAuditLegalHoldLink.click();
	}
	
	public void ClickCurrentAuditReportLink(){
		CurrentAuditReportLink.click();
	}
	
	public void ClickArchivedAuditReportLinkLink(){
		ArchivedAuditReportLinkLink.click();
	}
		


}
