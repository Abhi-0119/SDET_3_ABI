package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class HomePage // Rule 1
{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;

	@FindBy(xpath="//a[text()='Organizations']")//Rule 2
	private WebElement orglink; //Rule 3

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutimg;

	public WebElement getOrglink() //Rule 4
	{
		return orglink;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public HomePage(WebDriver driver) //Rule 5
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void logOutfromApp() throws InterruptedException
	{
		driver.navigate().refresh();
		WebDriverUtil webutil = new WebDriverUtil(driver);
		Thread.sleep(1000);
		webutil.movetoelement(logoutimg);
		Thread.sleep(3000);
		signoutlink.click();
	}


}
