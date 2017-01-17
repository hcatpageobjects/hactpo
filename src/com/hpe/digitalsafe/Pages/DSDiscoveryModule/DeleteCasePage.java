package com.hpe.digitalsafe.Pages.DSDiscoveryModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteCasePage {
	public WebDriver driver;
	public DeleteCasePage(WebDriver localdriver){
		this.driver=localdriver;
	}
    @FindBy(how=How.XPATH, using="(.//*[@class='x-treegrid-node-ct-table']//td[contains(.,'test123')])[1]")
    
  
	
	WebElement clickLink;
@FindBy(how=How.XPATH, using=".//*[@type='checkbox']")
    
  
	
	WebElement confirm;
    


	@FindBy(how=How.XPATH, using="(//span[text()='Create Case']/../../../../..//button[contains(text(),'Test1')]")
	WebElement test1;
	public void Delete_Case() {
		clickLink.click();
		System.out.println("Clicked");
		 WebDriverWait wait = new WebDriverWait(driver,40);
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Delete')]")));
		    element.click();
		    WebDriverWait wait1 = new WebDriverWait(driver,5);
		    WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@type='checkbox']")));
		    confirm.click();
		    WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[(text()='Delete')]")));
		    element2.click();
	}
	
	public void ImplWait(int timeinseconds){
		driver.manage().timeouts().implicitlyWait(timeinseconds, TimeUnit.SECONDS);
	}
}
