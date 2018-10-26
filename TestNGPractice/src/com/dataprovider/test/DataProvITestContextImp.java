package com.dataprovider.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;



public class DataProvITestContextImp {
	WebDriver w1;
	
	@BeforeTest(groups = {"A", "B"})
	public void setup() {
		System.setProperty("webdriver.firefox.marionette", "c://geckodriver.exe");
	}
	
	@Test(dataProvider="DataProviderTest" , dataProviderClass=DataProviderWithITestContext.class, groups = "A")
	public void ITestContextImp(String sUsername, String sPassword) {		
		String baseUrl = "https://gmail.com";
		w1=new FirefoxDriver();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait myWaitVar = new WebDriverWait(w1,10);
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xxxx")));
		
		w1.navigate().to(baseUrl);
		
		w1.findElement(By.xpath("//input[@id = 'Email']")).sendKeys(sUsername);
		w1.findElement(By.xpath("//input[@id = 'next']")).click();
		w1.findElement(By.xpath("//input[@id = 'Passwd']")).sendKeys(sPassword);
		w1.findElement(By.xpath("//input[@id = 'signIn']")).click();
	
	}
	
	@Test(dataProvider="DataProviderTest" ,dataProviderClass=DataProviderWithITestContext.class, groups="B")
	public void ITestContextImp(String searchKey) {
		
		String baseUrl = "htttps://google.com";
		w1= new FirefoxDriver();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait myWaitVar = new WebDriverWait(w1,10);
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("XXXX")));
		
		w1.navigate().to(baseUrl);
		
		w1.findElement(By.name("q")).sendKeys(searchKey);
		
		
		
		
	}

}
