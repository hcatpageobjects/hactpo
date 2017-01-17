package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateSelectCustodiansPage {
	public WebDriver driver;
	public CreateSelectCustodiansPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	   @FindBy(how=How.XPATH, using="//a[contains(.,'Create Custodian')]")
	
	   WebElement CreateCustodianButton;	
	
	   @FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
		
		WebElement NextButtonWithLink;
	   
	   @FindBy(how=How.XPATH, using="(//*[@name='AuditCreate_AuditCustodians'])[1]")
		
		WebElement FirstCustodianInList;
		
		@FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
		
		WebElement NextButtonOnContent;
	    
	    
	    public void Fill_CreateSelectCustodiansPage(String AuditType, String AuditName) {

	    	FirstCustodianInList.click();
	    	NextButtonOnContent.click();
			
			
		}

}
