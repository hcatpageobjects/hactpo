package com.hpe.digitalsafe.Pages.DSDModule;

import java.nio.charset.Charset;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DigitalSafeNewSearch {
	
	WebDriver driver;
	
	public DigitalSafeNewSearch(WebDriver localdriver){
		this.driver=localdriver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//*[center]//input[@value='Search']")
	@CacheLookup
	WebElement searchFilterButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//*[center]//input[@value='Search All']")
	@CacheLookup
	WebElement searchAllButton;
	
	@FindBy(how=How.ID, using="Filter")
	@CacheLookup
	WebElement filterRepositoriesTextBox;
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//input[@onclick='doFilter(); return false;']")
	@CacheLookup
	WebElement searchFilterRepositoriesButton;
	
	@FindBy(how=How.XPATH, using=".//*[@id='CharFilter']")
	@CacheLookup
	WebElement CharFilterDropDown;
	
	@FindBy(how=How.XPATH, using="//*[@id='contentPane']//input[@onclick='doCharFilter(); return false;']")
	@CacheLookup
	WebElement searchCharFilterButton;
	
	@FindBy(how=How.XPATH, using="//input[@id='allChecked']")
	@CacheLookup
	WebElement selectAllCheckBox;
	
	public void searchAll(){
		selectAllCheckBox.click();
		searchFilterButton.click();
		
	}
	
	public void searchByFiltering(String text){
		
		filterRepositoriesTextBox.sendKeys(text);
		searchFilterRepositoriesButton.click();
	}
	
	public void searchByCharFilter(CharSequence letter){
		CharFilterDropDown.sendKeys(letter);
		searchCharFilterButton.click();
	}

}
