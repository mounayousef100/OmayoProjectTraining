package com.omayoproject1.centerpagetest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.omayoproject1.base.BaseTest;
import com.omayoproject1.centerpageobject.TextAreaFieldPage;

public class TextAreaFieldTest extends BaseTest {

	private TextAreaFieldPage textAreaFieldPage;
	
	@Test()
	public void textAreaFieldTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		textAreaFieldPage = new TextAreaFieldPage();
		textAreaFieldPage.sendText();
		
		
	}
}
