package com.omayoproject1.centerpagetest;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.omayoproject1.base.BaseTest;
import com.omayoproject1.centerpageobject.LoginPage;

public class LoginTest extends BaseTest {
	private LoginPage loginPage ;
	
	@Test()
	public void loginTest() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		loginPage = new LoginPage() ;
		//اسم ال Object . اسم الميثود
		loginPage.loginWithValidUsernameAndPass();
		
		
		
	}
	
	
}
