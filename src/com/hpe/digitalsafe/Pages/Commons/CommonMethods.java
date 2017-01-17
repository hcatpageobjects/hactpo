package com.hpe.digitalsafe.Pages.Commons;

import org.openqa.selenium.WebElement;

public class CommonMethods {
	
	public void SelectCheckbox(WebElement xbox){
    	if(!xbox.isSelected())
    	{
    		xbox.click();
    	}
    }

}
