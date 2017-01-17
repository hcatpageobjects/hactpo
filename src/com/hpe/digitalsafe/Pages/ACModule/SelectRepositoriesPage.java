package com.hpe.digitalsafe.Pages.ACModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectRepositoriesPage {
	public WebDriver driver;
	public SelectRepositoriesPage(WebDriver localdriver){
		this.driver=localdriver;
	}
	@FindBy(how=How.XPATH, using="//*[@name='AuditCreate_RepositorySearchText']")
	WebElement AuditCreate_RepositorySearchTextBox;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Search')]")
	WebElement SearchButton;
	
	@FindBy(how=How.XPATH, using="(//*[@name='AuditCreate_RepositoryList'])[2]")
	WebElement FirstRepositoryInList;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_IncludeUnroutableDocumentsCheckBox']")
	WebElement IncludeUnroutableDocumentsCheckBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='AuditCreate_IncludeUnparsableDocumentsCheckBox']")
	WebElement IncludeUnparsableDocumentsCheckBox;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Select All')]")
	WebElement SelectAllButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(.,'Clear Selected')]")
	WebElement ClearSelectedButton;
	
    @FindBy(how=How.XPATH, using="(//a[contains(.,'Next')])[1]")
	WebElement NextButtonWithLink;
	
    public void Fill_SelectRepositoriesPage(String repository) {
    	
    	AuditCreate_RepositorySearchTextBox.sendKeys(repository);
    	SearchButton.click();
    	FirstRepositoryInList.click();
    	IncludeUnroutableDocumentsCheckBox.click();
    	IncludeUnparsableDocumentsCheckBox.click();
    	NextButtonWithLink.click();
}
    
    

}
