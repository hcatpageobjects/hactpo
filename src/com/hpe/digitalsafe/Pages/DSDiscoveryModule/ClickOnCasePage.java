package com.hpe.digitalsafe.Pages.DSDiscoveryModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClickOnCasePage {
	public WebDriver driver;
	public ClickOnCasePage(WebDriver localdriver){
		this.driver=localdriver;
	}
    @FindBy(how=How.XPATH, using="//span[text()='venu_d']")
    
  
	
	WebElement clickLink;
    
    @FindBy(how=How.XPATH, using="//button[contains(text(),'Collections')]")
    WebElement Collections_Button;
    @FindBy(how=How.XPATH, using="//button[contains(text(),'Reports')]")
    WebElement Reports_Button;
    @FindBy(how=How.XPATH, using="//button[contains(text(),'Search')]")
    WebElement Search_Button;
    
    
//    @FindBy(how=How.NAME, using="status")
//	
//	WebElement case_status;
//	
//    @FindBy(how=How.NAME, using="name")
//	
//	WebElement case_name;
//	
//	@FindBy(how=How.NAME, using="stringId")
//	
//	WebElement case_id;
//	
//	@FindBy(how=How.NAME, using="notes")
//	
//	WebElement case_Notes;
//	
//	@FindBy(how=How.LINK_TEXT, using="Next »")
//	
//	
//	WebElement NextButtonWithLink;
//	
	@FindBy(how=How.XPATH, using="(//span[text()='Create Case']/../../../../..//button[contains(text(),'Test1')]")
	WebElement test1;
	public void Click_OnCase() {
		clickLink.click();
     	 WebDriverWait wait = new WebDriverWait(driver,40);
//		 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Collections')]")));
//		 Collections_Button.click();
//		 WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Reports')]")));
//		 Reports_Button.click();
		 WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Search')]")));
		 Search_Button.click();
		 WebDriverWait wait1 = new WebDriverWait(driver,4);
	//	 WebElement element4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[contains(text(),'Add Field')]")));
		// element4.click();
		 WebElement element5 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(text()='Docclass')]/following-sibling::div[1]")));
		 element5.click();
		 WebElement element6 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(text()='Email')]")));
		 element6.click();
		 WebElement element7 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[(text()='Add Field')]")));
		 element7.click();
		 WebElement element8 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	 .//*[@class='x-form-field-wrap x-form-field-trigger-wrap x-trigger-wrap-focus']//img[@src='/introspect/styles/resources/images/default/s.gif']")));
		 element8.click();
	
		//div[(text()='Email')]
		 System.out.println("11");
		
	}
	
	public void ImplWait(int timeinseconds){
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}
}
