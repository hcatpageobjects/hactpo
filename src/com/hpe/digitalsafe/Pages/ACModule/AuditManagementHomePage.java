package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuditManagementHomePage {
    public WebDriver driver;
	public AuditManagementHomePage(WebDriver localdriver) {
      this.driver=localdriver;
	}
	private String RequiredSystemNameXpath = "//a[contains(text(),'xxxxx')]";;
	
	public void setRequiredSystemNameXpath(String AuditName) {
		this.RequiredSystemNameXpath = AuditName;
	}

	@FindBy(how=How.ID, using="findName")
	WebElement AuditNameTextBox;
	
	@FindBy(how=How.ID, using="findOwner")
	WebElement AuditOwnerTextBox;
	
	@FindBy(how=How.XPATH, using=".//*[@value='Find']")
	WebElement FindButton;
	
	@FindBy(how=How.ID, using="dvDomains")
	WebElement DomainsDropDown;
	

	private WebElement auditNameInList (String xpathValue, String substitutionValue ) {
	        return driver.findElement(By.xpath(xpathValue.replace("xxxxx", substitutionValue)));
	}

	public void ClickAuditNameInList (String systemName) {


	    WebElement RequiredSystemName = auditNameInList(RequiredSystemNameXpath, systemName);

	    RequiredSystemName.click();

	}
	
	public void ClickAuditName(String AuditName){
		String AuditNameNew=AuditName;
		ClickAuditNameInList(AuditNameNew);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
