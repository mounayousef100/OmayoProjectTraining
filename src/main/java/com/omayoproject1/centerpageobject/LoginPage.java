package com.omayoproject1.centerpageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.omayoproject1.actiondriver.Action;
import com.omayoproject1.base.BasePage;

public class LoginPage extends BasePage {

	Action action = new Action();
	
	@FindBy(name = "userid")
	private WebElement usernameField;
	
	@FindBy(name = "pswrd")
	private WebElement passwordField ;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton ;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void loginWithValidUsernameAndPass() {
		action.sendText(usernameField, "muna@gmail.com");
		action.sendText(passwordField, "1234muna");
		action.click(loginButton);
		action.AlertAccept(driver);
		Assert.assertTrue(false);
		
	}
	
	
}
