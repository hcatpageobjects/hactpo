package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManageCustodiansHomePage {
    WebDriver driver;
	public ManageCustodiansHomePage(WebDriver localdriver) {
    this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="")
	WebElement Button;

}
