package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.hpe.digitalsafe.Pages.Commons.*;

public class SelectDateRangePage {
	public WebDriver driver;
	public SelectDateRangePage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using=".//*[@id='AuditCreate_DateArchivedEnableCheckBox']")
	WebElement DateArchivedEnableCheckBox;
	
	@FindBy(how=How.XPATH,using="")
	WebElement xxxx;
	
	@FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
	WebElement NextButtonOnContent;
	
    @FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[0]")
	WebElement BackButtonOnContent;
    
    
    public void Fill_SelectdateRangePage(String AuditType, String AuditName) {
    	//SelectCheckbox(DateArchivedEnableCheckBox);
    	NextButtonOnContent.click();
       }
    
    
}
