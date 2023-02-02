package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	private WebDriver driver;
	
	private By username=By.name("email");
	private By password=By.name("password");
	private By login=By.xpath("//div[text()='Login']");
	private By forgotPwdLink=By.xpath("//a[text()='Forgot your password?']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String user_name) {
		driver.findElement(username).sendKeys(user_name);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	public ContactsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		return new ContactsPage(driver);
	}

}
