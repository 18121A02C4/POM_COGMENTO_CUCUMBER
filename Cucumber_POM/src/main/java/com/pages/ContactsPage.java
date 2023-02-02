package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactsPage {
private WebDriver driver;
Actions act;
	
	private By contactsLogo=By.xpath("//span[text()='Contacts']/preceding-sibling::i");
	private By plusIcon=By.xpath("//span[text()='Contacts']/parent::a/following-sibling::button/i");
	private By move=By.xpath("//a[text()='Free account']");
	private By contactsTxt=By.xpath("//span[text()='Contacts']");
	private By contactsLabel=By.xpath("//div[text()='Contacts']");
	private By firstName=By.xpath("//input[@name='first_name']");
	private By lastName=By.xpath("//input[@name='last_name']");	
	private By saveButton=By.xpath("//button[text()='Save']");
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnContacts() {
		 act=new Actions(driver);
		act.moveToElement(driver.findElement(contactsLogo)).build().perform();
		act.moveToElement(driver.findElement(contactsTxt)).click().build().perform();
		act.moveToElement(driver.findElement(move)).build().perform();

	}
	public boolean isContactsLabelExist() {
		return driver.findElement(contactsLabel).isDisplayed();
	}
	public void clickOnPerson(String naam) throws InterruptedException {
		 act=new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//a[text()='"+naam+"']/parent::td/preceding-sibling::td//input[@name='id']"))).click().build().perform();
		Thread.sleep(3000);
//		return driver.findElement(By.xpath("//a[text()='"+naam+"']/parent::td/preceding-sibling::td//input")).isSelected();
	}
	public void clickOnNewContacts() throws InterruptedException {
		act = new Actions(driver);
		act.moveToElement(driver.findElement(contactsLogo)).build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(plusIcon)).click().build().perform();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(move)).build().perform();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



	}
	public void enterFirstName(String first_name) {
		driver.findElement(firstName).sendKeys(first_name);
	}

	public void enterLastName(String last_name) {
		driver.findElement(lastName).sendKeys(last_name);
	}
	public void clickOnSave() {
		driver.findElement(saveButton).click();
	}

		
		

}
