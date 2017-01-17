package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemoveAuditLegalHoldHomePage {

	WebDriver driver;
	public RemoveAuditLegalHoldHomePage(WebDriver localdriver) {
    this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="")
	WebElement Button;
	
}
