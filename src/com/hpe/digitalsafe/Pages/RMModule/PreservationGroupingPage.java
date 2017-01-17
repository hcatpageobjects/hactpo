package com.hpe.digitalsafe.Pages.RMModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PreservationGroupingPage {

	WebDriver driver;
	public PreservationGroupingPage(WebDriver localdriver) {
		this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="new-grouping")
	WebElement NewButton;
	
	@FindBy(how=How.ID, using="edit-grouping")
	WebElement EditButton;
	
	@FindBy(how=How.ID, using="delete-grouping")
	WebElement DeleteButton;
	
	@FindBy(how=How.ID, using="deactivate")
	WebElement DeactivateCheckBox;
	
	public void ClickNewButton(){
		NewButton.click();
	}
	
	public void ClickEditButton(){
		EditButton.click();
	}
	
	public void ClickDeleteButton(){
		DeleteButton.click();
	}
	
	public void SelectDeactivateCheckBox(){
		DeactivateCheckBox.click();
	}
	
	

}
