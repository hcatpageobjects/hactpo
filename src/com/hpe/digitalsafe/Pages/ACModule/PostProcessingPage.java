package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PostProcessingPage {
	
	public WebDriver driver;
	public PostProcessingPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_SelectEmailAddress']")
	WebElement SelectEmailAddressCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_DateGapReport']")
	WebElement DateGapReportCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_SevenDays']")
	WebElement SevenDaysCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_TwentyOneDays']")
	WebElement TwentyOneCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_FourteenDays']")
	WebElement FourteenCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_TwentyEightDays']")
	WebElement TwentyEightCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_DaysField']")
	WebElement DaysFieldTextBox;
	
    @FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
	WebElement NextButtonWithLink;
	
    public void Fill_PostProcessingPage(String days) {
    	
    	ifStatement(SelectEmailAddressCheckBox);
    	ifStatement(DateGapReportCheckBox);
    	
    	//TwentyOneCheckBox.click();
    	//FourteenCheckBox.click();
    	DaysFieldTextBox.sendKeys(days);
    	NextButtonWithLink.click();
	}
    
    public void ifStatement(WebElement E){
    	
    	if (!E.isSelected()) {
    		E.click();
		}
    	
    }

}
