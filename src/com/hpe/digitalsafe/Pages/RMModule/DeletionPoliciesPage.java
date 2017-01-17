package com.hpe.digitalsafe.Pages.RMModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeletionPoliciesPage {
	
	public WebDriver driver;
	public DeletionPoliciesPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="ned-typelist")
	WebElement PolicyTypeList;
	
	@FindBy(how=How.ID, using="new-active-deletion")
	WebElement ActiveDeletionNewButton;
	
	@FindBy(how=How.ID, using="edit-active-deletion")
	WebElement ActiveDeletionEditButton;
	
	@FindBy(how=How.ID, using="deactivate-active-deletion")
	WebElement ActiveDeletionDeactivateButton;
	
	@FindBy(how=How.ID, using="new-inactive-deletion")
	WebElement InactiveDeletionNewButton;
	
	@FindBy(how=How.ID, using="edit-inactive-deletion")
	WebElement InactiveDeletionEditButton;
	
	@FindBy(how=How.ID, using="deactivate")
	WebElement DeletionDeactivateButton;
	
	@FindBy(how=How.ID, using="activate")
	WebElement DeletionactivateButton;
	
	@FindBy(how=How.ID, using="filter-active")
	WebElement FilterActiveTextBox;
	
	@FindBy(how=How.ID, using="filter-inactive")
	WebElement FilterInactiveTextBox;
	
	
	@FindBy(how=How.ID, using="ned-type-active-deletion")
	WebElement FilterActiveDeletionListBox;
	
	@FindBy(how=How.ID, using="ned-type-inactive-deletion")
	WebElement FilteInactiveDelectionListBox;
	
	
	
	
	
	public void Fill_NewActiveDeletionPolicy(){
		PolicyTypeList.sendKeys("Active Deletion Policies");
		ActiveDeletionNewButton.click();
		
	}
	
    public void Filter_EditActiveDeletionPolicy(CharSequence policyName){
    	
    	PolicyTypeList.sendKeys("Active Deletion Policies");
    	FilterActiveTextBox.sendKeys(policyName);
    	FilterActiveDeletionListBox.sendKeys(policyName);
    	ActiveDeletionEditButton.click();
    	
    }
    
    public void Filter_DeactivateActiveDeletionPolicy(CharSequence policyName){
    	
    	PolicyTypeList.sendKeys("Active Deletion Policies");
    	FilterActiveTextBox.sendKeys(policyName);
    	FilterActiveDeletionListBox.sendKeys(policyName);
    	ActiveDeletionDeactivateButton.click();
    	
    }

	

}
