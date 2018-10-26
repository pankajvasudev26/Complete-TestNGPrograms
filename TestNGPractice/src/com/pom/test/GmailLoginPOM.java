package com.pom.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLoginPOM {
	
	WebDriver w1;
	
	By UserName = By.xpath("//input[@id='Email']");
	By NextPage_Username = By.xpath("//input[@id='next']");
	By Password = By.xpath("//input[@id='Passwd']");
	By NextPage_password = By.xpath("//input[@id='signIn']");
	
	public GmailLoginPOM(WebDriver w1){
		this.w1 = w1;
	}
	
	public void setUsername(String sUser) {
		
		w1.findElement(UserName).sendKeys(sUser);
		
	}
	
	public void moveToPassword() {
		
		w1.findElement(NextPage_Username).click();
		
	}
	
	public void setPassword(String sPasswd) {
		
		w1.findElement(Password).sendKeys(sPasswd);
		
	}
	
	public void login() {
		
		w1.findElement(NextPage_password).click();
		
	}
	
	public void LoginToGmail(String sUsername, String sPassword) {
		
		this.setUsername(sUsername);
		
		this.moveToPassword();
		
		this.setPassword(sPassword);
		
		this.login();
		
		
		
		
	}

}
