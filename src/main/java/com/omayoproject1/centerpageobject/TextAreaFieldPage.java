package com.omayoproject1.centerpageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omayoproject1.actiondriver.Action;
import com.omayoproject1.base.BasePage;

public class TextAreaFieldPage extends BasePage {
	Action action = new Action();
	
	@FindBy(id = "ta1")
	private WebElement textAreaField;
	
	public TextAreaFieldPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void sendText() throws InterruptedException {
		
		action.sendText(textAreaField, "I love Quality Assurance and Automation");
		Thread.sleep(4000);
	}

}
