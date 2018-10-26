package com.dataprovider.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.Iterator;
import java.lang.reflect.Method;

import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Factory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Optional;





public class DataProviderITestContext {
	
	WebDriver w1;

	@DataProvider(name = "ITestContextDP")
	public Object[][] credentials(ITestContext c){
		Object[][] groupArray = null;
		for(String group : c.getIncludedGroups()) {
			if(group.equalsIgnoreCase("A")) {
				groupArray = new Object[][] {{"pankajvasudev26","9816382929"},{"pankajvasudev2013","9816382929"}};
				break;
			}// End of If statement of Group A
			else if(group.equalsIgnoreCase("B")) {
				groupArray = new Object[][] {{"INDIA"},{"CHINA"},{"ENGLAND"}};
				break;
			}// End of If statement of Group B			
		} //End of For-Each loop		
		return groupArray;		
	} //End of DataProvider
	
	@BeforeTest(groups= {"A","B"})
	public void setUp() {
		System.setProperty("webdriver.firefox.marionette", "c://geckodriver.exe");		
	}
	
	@Test(dataProvider = "ITestContextDP", groups="A" )
	public void loginToGmail(@Optional("Abc") String sUsername, String sPassword) {
		
		String baseUrl = "https://gmail.com";
		w1 = new FirefoxDriver();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait myWaitVar = new WebDriverWait(w1,10);
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xxxx")));
		
		w1.navigate().to(baseUrl);
		
		w1.findElement(By.xpath("//input[@id='Email']")).sendKeys(sUsername);
		w1.findElement(By.xpath("//input[@id='next']")).click();
		w1.findElement(By.xpath("//input[@id='Passwd']")).sendKeys(sPassword);
		w1.findElement(By.xpath("//input[@id='signIn']")).click();
	}
	
	@Test(dataProvider="ITestContextDP", groups="B")
	public void searchText(String searchKey) {
		
		String baseUrl = "https://google.com";
		w1 = new FirefoxDriver();
		w1.manage().window().maximize();
		w1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait myWaitVar = new WebDriverWait(w1,10);
		//myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("xxxx")));
		
		w1.navigate().to(baseUrl);
		
		w1.findElement(By.xpath("//input[@name='q']")).sendKeys(searchKey);
		
		
	}
} //End of class
