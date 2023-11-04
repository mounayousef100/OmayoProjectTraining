package com.omayoproject1.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.google.common.base.Supplier;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	private static final String EDGE = "edge";
	private static final String IE = "ie";
	
	private static final Map< String , Supplier <WebDriver>> BROWSER_MAP = Map.of(CHROME,ChromeDriver ::new,
			EDGE,EdgeDriver ::new,
			IE,InternetExplorerDriver::new,
			FIREFOX,FirefoxDriver::new);
	
	protected static Properties prop;
	protected static WebDriver driver ;
	 
	public static WebDriver initializeDriver() throws IOException {
			
		WebDriverManager.chromedriver().setup();
		prop = new Properties();
		try(FileInputStream file = new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\data.properties" ))
			{
			prop.load(file);
		}
		catch(IOException e){
			throw new IOException ("Failed to load configration file :" + e.getMessage());
		
		}
		
		String browserName = prop.getProperty("browser");
	
		driver = BROWSER_MAP.getOrDefault(browserName.toLowerCase(),() ->{
			throw new IllegalArgumentException("Invalid browser name :" + browserName);
		}).get();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver ;
		
	}

    public static void takeScreenshot(String testName) throws IOException {
    	File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ testName + ".png";
        FileUtils.copyFile(sourceFile, new File (destinationFilePath));
    	
    }

    
	}
	
	

