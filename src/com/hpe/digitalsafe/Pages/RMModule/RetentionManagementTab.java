package com.hpe.digitalsafe.Pages.RMModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RetentionManagementTab {

public WebDriver driver;
	
	public RetentionManagementTab(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Retention Policies')]")
	
	WebElement RetentionPoliciesLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Preservation Grouping')]")
	
	WebElement PreservationGroupingLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Deletion Policies')]")
	
	WebElement DeletionPoliciesLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Keyword Lists')]")
	
	WebElement KeywordListsLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Retention Policy Report')]")
	
	WebElement RetentionPolicyReportLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Keyword List Report')]")
	
	WebElement KeywordListReportLink;
	
    @FindBy(how=How.XPATH, using="//a[contains(.,'Grouping Report')]")
	
	WebElement GroupingReportLink;

    @FindBy(how=How.XPATH, using="//a[contains(.,'Policy Audit Report')]")
	
	WebElement PolicyAuditReportLink;
    
    @FindBy(how=How.XPATH, using="//a[contains(.,'Tasks')]")
	
	WebElement TasksLink;
	
	
	public void ClickRetentionPoliciesLink(){
		RetentionPoliciesLink.click();
	}
	
	public void ClickPreservationGroupingLink(){
		PreservationGroupingLink.click();
	}
	
	public void ClickDeletionPoliciesLink(){
		DeletionPoliciesLink.click();
	}
	public void ClickKeywordListsLink(){
		KeywordListsLink.click();
	}
	public void ClickRetentionPolicyReportLink(){
		RetentionPolicyReportLink.click();
	}
	public void ClickKeywordListReportLink(){
		KeywordListReportLink.click();
	}
	public void ClickGroupingReportLink(){
		GroupingReportLink.click();
	}
	public void ClickPolicyAuditReportLink(){
		PolicyAuditReportLink.click();
	}
	public void ClickTasksLink(){
		TasksLink.click();
	}
	
		


}
