package com.hpe.digitalsafe.Pages.RMModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RetentionPoliciesPage {
	
	public WebDriver driver;
	public RetentionPoliciesPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="ned-typelist")
	WebElement PolicyTypeList;
	
	@FindBy(how=How.ID, using="new-active-preservation")
	WebElement ActivePreservationNewButton;
	
	@FindBy(how=How.ID, using="edit-active-preservation")
	WebElement ActivePreservationEditButton;
	
	@FindBy(how=How.ID, using="test-active-preservation")
	WebElement ActivePreservationTestButton;
	
	@FindBy(how=How.ID, using="deactivate-active-preservation")
	WebElement ActivePreservationDeactivateButton;
	
	@FindBy(how=How.ID, using="new-active-operational")
	WebElement ActiveOperationalNewButton;
	
	@FindBy(how=How.ID, using="edit-active-operational")
	WebElement ActiveOperationalEditButton;
	
	@FindBy(how=How.ID, using="test-active-operational")
	WebElement ActiveOperationalTestButton;
	
	@FindBy(how=How.ID, using="deactivate-active-operational")
	WebElement ActiveOperationalDeactivateButton;
	
	@FindBy(how=How.ID, using="new-active-compliance")
	WebElement ActiveComplianceNewButton;
	
	@FindBy(how=How.ID, using="edit-active-compliance")
	WebElement ActiveComplianceEditButton;
	
	@FindBy(how=How.ID, using="test-active-compliance")
	WebElement ActiveComplianceTestButton;
	
	@FindBy(how=How.ID, using="deactivate-active-compliance")
	WebElement ActiveComplianceDeactivateButton;
		
	@FindBy(how=How.ID, using="new-inactive-preservation")
	WebElement InactivePreservationNewButton;
	
	@FindBy(how=How.ID, using="edit-inactive-preservation")
	WebElement InactivePreservationEditButton;
	
	@FindBy(how=How.ID, using="test-inactive-preservation")
	WebElement InactivePreservationTestButton;
	
	@FindBy(how=How.ID, using="deactivate-inactive-preservation")
	WebElement InactivePreservationDeactivateButton;
	
	@FindBy(how=How.ID, using="new-inactive-operational")
	WebElement InactiveOperationalNewButton;
	
	@FindBy(how=How.ID, using="edit-inactive-operational")
	WebElement InactiveOperationalEditButton;
	
	@FindBy(how=How.ID, using="test-inactive-operational")
	WebElement InactiveOperationalTestButton;
	
	@FindBy(how=How.ID, using="deactivate-inactive-operational")
	WebElement InactiveOperationalDeactivateButton;
	
	@FindBy(how=How.ID, using="new-inactive-compliance")
	WebElement InactiveComplianceNewButton;
	
	@FindBy(how=How.ID, using="edit-inactive-compliance")
	WebElement InactiveComplianceEditButton;
	
	@FindBy(how=How.ID, using="test-inactive-compliance")
	WebElement InactiveComplianceTestButton;
	
	@FindBy(how=How.ID, using="deactivate-inactive-compliance")
	WebElement InactiveComplianceDeactivateButton;
	
	@FindBy(how=How.ID, using="filter-active-pres")
	WebElement FilterActivePreservationTextBox;
	
	@FindBy(how=How.ID, using="filter-active-oper")
	WebElement FilterActiveOperationalTextBox;
	
	@FindBy(how=How.ID, using="filter-active-comp")
	WebElement FilterActiveComplianceTextBox;
	
	@FindBy(how=How.ID, using="filter-inactive-pres")
	WebElement FilterInActivePreservationTextBox;
	
	@FindBy(how=How.ID, using="filter-inactive-oper")
	WebElement FilterInActiveOperationalTextBox;
	
	@FindBy(how=How.ID, using="filter-inactive-comp")
	WebElement FilterInActiveComplianceTextBox;
	
	@FindBy(how=How.ID, using="ned-type-active-preservation")
	WebElement FilterActivePreservationListBox;
	
	@FindBy(how=How.ID, using="ned-type-active-operational")
	WebElement FilterActiveOperationalListBox;
	
	@FindBy(how=How.ID, using="ned-type-active-compliance")
	WebElement FilterActiveComplianceListBox;
	
	@FindBy(how=How.ID, using="ned-type-inactive-preservation")
	WebElement FilterInActivePreservationListBox;
	
	@FindBy(how=How.ID, using="ned-type-inactive-operational")
	WebElement FilterInActiveOperationalListBox;
	
	@FindBy(how=How.ID, using="ned-type-inactive-compliance")
	WebElement FilterInActiveComplianceListBox;
	
	
	
	public void Fill_NewActivePreservationPolicyPage(){
		
		PolicyTypeList.sendKeys("Active Preservation Policies");
		ActivePreservationNewButton.click();
		
	}
	
    public void Fill_NewActiveOperationalPolicyPage(){
    	
    	PolicyTypeList.sendKeys("Active Operational Policies");
		ActiveOperationalNewButton.click();
		
	}
    
    public void Fill_NewActiveCompliancePolicyPage(){
    	
    	PolicyTypeList.sendKeys("Active Compliance Policies");
		ActiveComplianceNewButton.click();
	
    }
    
    public void Fill_NewInActivePreservationPolicyPage(){
		
	}
	
    public void Fill_NewInActiveOperationalPolicyPage(){
		
	}
    public void Fill_NewInActiveCompliancePolicyPage(){
	
    }
    
    public void Filter_EditActivePreservationPolicyPage(CharSequence policyName){
    	
    	PolicyTypeList.sendKeys("Active Preservation Policies");
    	FilterActivePreservationTextBox.sendKeys(policyName);
    	FilterActivePreservationListBox.sendKeys(policyName);
    	ActivePreservationEditButton.click();
    	
    	
    }
    
public void Filter_DeleteActivePreservationPolicyPage(CharSequence policyName){
    	
    	PolicyTypeList.sendKeys("Active Preservation Policies");
    	FilterActivePreservationTextBox.sendKeys(policyName);
    	FilterActivePreservationListBox.sendKeys(policyName);
    	ActivePreservationDeactivateButton.click();
    	
    	
    }

	

}
