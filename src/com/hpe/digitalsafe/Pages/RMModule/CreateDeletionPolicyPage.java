package com.hpe.digitalsafe.Pages.RMModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateDeletionPolicyPage {

	public WebDriver driver;
	public CreateDeletionPolicyPage(WebDriver localdriver) {
		this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="name")
	WebElement NameTextBox;
	
	@FindBy(how=How.ID, using="desc")
	WebElement DescriptionTextBox;
	
	@FindBy(how=How.ID, using="active")
	WebElement ActiveCheckBox;
	
	@FindBy(how=How.ID, using="match-type")
	WebElement MatchTypeDropdown;
	
	@FindBy(how=How.ID, using="type")
	WebElement MessageTypeDropdown;
	
	@FindBy(how=How.NAME, using="tag")
	WebElement TagDropdown;
	
	@FindBy(how=How.NAME, using="qualification")
	WebElement ContainsDropdown;
	
	@FindBy(how=How.NAME, using="wordy")
	WebElement SearchTextBox;
	
	@FindBy(how=How.ID, using="save")
	WebElement SaveButton;
	
	@FindBy(how=How.ID, using="cancel")
	WebElement CancelButton;
	
	public void TypeInNameTextBox(CharSequence policyName){
		NameTextBox.sendKeys(policyName);
		}
	
	public void TypeInDescriptionTextBox(CharSequence description){
		DescriptionTextBox.sendKeys(description);
		}
	
	public void SelectActiveCheckBox(String option){
		if(option.equalsIgnoreCase("check")){
		ActiveCheckBox.click();
		}
	    }
	
	
	public void Fill_NewDeletionPolicyForm(CharSequence policyName,CharSequence description,String option){
		
		TypeInNameTextBox(policyName);
		TypeInDescriptionTextBox(description);
		SelectActiveCheckBox(option);
		
		SaveButton.click();
		
	}

}
