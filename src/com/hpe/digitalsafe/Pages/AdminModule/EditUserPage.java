package com.hpe.digitalsafe.Pages.AdminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditUserPage {
    WebDriver driver;
	public EditUserPage(WebDriver localdriver) {
    this.driver=localdriver;
	}
	
	@FindBy(how=How.ID, using="userList")
	WebElement BackButton;
	
	@FindBy(how=How.ID, using="userListPopup")
	WebElement ShowUserButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'reset')]")
	WebElement ResetButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'print')]")
	WebElement PrintButton;
	
	@FindBy(how=How.ID, using="userForm:password")
	WebElement PasswordTextField;
	
	@FindBy(how=How.ID, using="userForm:confirmPassword")
	WebElement ConfirmPasswordTextField;
	
	@FindBy(how=How.ID, using="//a[contains(@href,'generatePassword')]")
	WebElement GeneratePasswordButton;
	
	@FindBy(how=How.ID, using="collapse_title")
	WebElement OpenRetentionFrame;
	
	@FindBy(how=How.ID, using="userForm:rmEnabled")
	WebElement EnableRetentionCheckBox;
	
	@FindBy(how=How.ID, using="roleId_160")
	WebElement DispositionReviewerRadioButton;
	
	@FindBy(how=How.ID, using="roleId_161")
	WebElement DispositionApproverRadioButton;
	
	@FindBy(how=How.ID, using="roleId_162")
	WebElement DSAdminCheckBox;
	
	@FindBy(how=How.XPATH, using="(//*[@name='userForm:status'])[1]")
	WebElement ActiveUserRadioButton;
	
	@FindBy(how=How.XPATH, using="(//*[@name='userForm:status'])[2]")
	WebElement InactiveActiveUserRadioButton;
	
	@FindBy(how=How.XPATH, using="//a[contains(@href,'saveForm')]")
	WebElement ConfirmButton;

}
