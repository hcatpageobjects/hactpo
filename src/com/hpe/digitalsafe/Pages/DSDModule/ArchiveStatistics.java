package com.hpe.digitalsafe.Pages.DSDModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ArchiveStatistics {
	
	WebDriver driver;

	public ArchiveStatistics(WebDriver localdriver) {
		this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="v-date-start")
	WebElement StartDateField;
	
		
	@FindBy(how=How.ID, using="v-date-end")
	WebElement EndDateField;
	
		
	@FindBy(how=How.NAME, using="submit")
	WebElement SubmitReportButton;
	
	public void EnterStartDate(String startDate){
		StartDateField.sendKeys(startDate);
	}
	
	public void EnterEndDate(String endDate){
	EndDateField.sendKeys(endDate);
    }
	
	public void FillDates(String startDate, String endDate){
		EnterStartDate(startDate);
		EnterEndDate(endDate);
		SubmitReportButton.click();
	}
}
