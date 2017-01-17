package com.hpe.digitalsafe.Pages.ACModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ConfirmAndRunPage {
	
	public WebDriver driver;
	public ConfirmAndRunPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	
   @FindBy(how=How.XPATH, using="//a[contains(.,'Back')]")
	
	WebElement BackButtonWithLink;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Run Audit')]")
	
	WebElement NextButtonWithLink;
	
    @FindBy(how=How.XPATH, using="//a[contains(.,'Save As Template')]")
	
	WebElement SaveAsTemplateButtonWithLink;
	
	@FindBy(how=How.XPATH, using="(//*[@id='contentPane']//input[@type='submit'])[1]")
	
	WebElement NextButtonOnContent;
    
    
    public void SubmitAudit() {
    	ImplWait(100);
    	NextButtonOnContent.click();
    	//Assert.assertEquals(true, driver.getPageSource().contains(""));
	}
    
    public void CreateTemplateAndSubmit(String TemplateName){
    	SaveAsTemplateButtonWithLink.click();
    	driver.switchTo().alert().sendKeys(TemplateName);
    	driver.switchTo().alert().accept();
    	SubmitAudit();
    }
    
    public void CreateTemplate(String TemplateName){
    	SaveAsTemplateButtonWithLink.click();
    	driver.switchTo().alert().sendKeys(TemplateName);
    	driver.switchTo().alert().accept();
    }
    public void ImplWait(int timeinseconds){
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}

}
