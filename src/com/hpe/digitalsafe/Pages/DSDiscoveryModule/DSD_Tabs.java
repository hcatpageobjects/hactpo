package com.hpe.digitalsafe.Pages.DSDiscoveryModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DSD_Tabs {

public WebDriver driver;
	
	public DSD_Tabs(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Add Case')]")
	
	WebElement addCase;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Edit Case')]")
	
	WebElement editCase;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Delete')]")
	
	WebElement delete;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Refresh')]")
	
	WebElement refresh;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Home')]")
	
	WebElement home;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Export Report')]")
	
	WebElement exPortReport;
	
	
	public void ClickAddCaseLink(){
		addCase.click();
	
		
	}
	
	public void ClickEditCaseLink(){
		editCase.click();
	}
	
	public void ClickDeleteLink(){
		delete.click();
	}
	
	public void ClickRefreshLink(){
		refresh.click();
	}
	
	public void ClickCurrentAuditReportLink(){
		home.click();
	}
	
	public void ClickArchivedAuditReportLinkLink(){
		exPortReport.click();
	}
		


}
