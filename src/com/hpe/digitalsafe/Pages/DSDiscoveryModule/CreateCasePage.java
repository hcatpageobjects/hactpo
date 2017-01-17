package com.hpe.digitalsafe.Pages.DSDiscoveryModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateCasePage {
	public WebDriver driver;
	public CreateCasePage(WebDriver localdriver){
		this.driver=localdriver;
	}
    @FindBy(how=How.XPATH, using="//button[contains(.,'Add Case...')]")
	
	WebElement addCaseLink;
    
    @FindBy(how=How.NAME, using="status")
	
	WebElement case_status;
	
    @FindBy(how=How.NAME, using="name")
	
	WebElement case_name;
	
	@FindBy(how=How.NAME, using="stringId")
	
	WebElement case_id;
	
	@FindBy(how=How.NAME, using="notes")
	
	WebElement case_Notes;
	
	@FindBy(how=How.XPATH, using="//button[contains(.,'Next')]")
	
	
	WebElement NextButtonWithLink;
	@FindBy(how=How.XPATH, using="//button[contains(.,'Create')]")
	
	
	WebElement CreateButtonWithLink;
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Test1')]")
	WebElement test1;
	public void Fill_CreateCase(String name, String id,String notes) {
		case_name.sendKeys(name);
		ImplWait(5);
		
		case_id.sendKeys(id);
		case_Notes.sendKeys(notes);
		   WebDriverWait wait1 = new WebDriverWait(driver,10);
		    WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Next')]")));
		   
		NextButtonWithLink.click();
		 WebElement element2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create')]")));
		CreateButtonWithLink.click();
		System.out.println("Clicked on create");
		  WebDriverWait wait2 = new WebDriverWait(driver,10);
		
		
	}
	
	public void ImplWait(int timeinseconds){
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}
}
