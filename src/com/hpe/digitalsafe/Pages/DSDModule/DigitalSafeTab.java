package com.hpe.digitalsafe.Pages.DSDModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DigitalSafeTab {
	
	public WebDriver driver;
	
	public DigitalSafeTab(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'New Search')]")
	WebElement NewSearchLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Statistics')]")
	WebElement StatisticsLink;
	
	public void ClickNewSearchLink(){
		NewSearchLink.click();
	}
	
	public void ClickStatisticsLink(){
		StatisticsLink.click();
	}

}
