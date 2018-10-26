package com.pagefactory.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
public class PageFactoryImplementation {
	
	WebDriver w1;
	
	
	@BeforeTest
	public void setup() {
		String baseUrl = "https://gmail.com";
		System.setProperty("webdriver.firefox.marionette", "c://geckodriver.exe");
		w1 = new FirefoxDriver();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	WebDriverWait myWaitVar = new WebDriverWait(w1,10);
	//	myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xxxx")));
		
		w1.navigate().to(baseUrl);
			
	}
	
	@Test
	public void LoginToPage() {
		
		LoginToGmailPageFacory objlogin = new LoginToGmailPageFacory(w1);
		
		objlogin.LoginToGmail("pankajvasudev26", "9816382929");
		
	}
	
	
	

	
	
	

}
