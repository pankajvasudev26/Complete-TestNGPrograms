package com.pagefactory.test;
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


public class LoginToGmailPageFacory {

	WebDriver w1;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='next']")
	WebElement User_next;
	
	@FindBy(xpath = "//input[@id='Passwd']")
	WebElement Password;
	
	@FindBy(xpath = "//input[@id='signIn']")
	WebElement sign_in;
	
	
	public LoginToGmailPageFacory(WebDriver w1) {
		
		this.w1 = w1;
		PageFactory.initElements(w1, this);
		
	}
	
	public void setUsername(String sUsername) {
		
		Username.sendKeys(sUsername);
	}
	
	public void goToNextPage() {
	
		User_next.click();
		
	}
	
	public void setPassword(String sPassword) {
		
		Password.sendKeys(sPassword);
		
	}
	
	public void login() {
		
		sign_in.click();
		
	}
	
	public void LoginToGmail(String sUsername, String sPassword) {
		
		this.setUsername(sUsername);
		this.goToNextPage();
		this.setPassword(sPassword);
		this.login();
		
	}
			
}
