package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactOrg_popup  
{
	WebDriver driver;

	public ContactOrg_popup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement searchorgtxtfld;

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchbtn;

	@FindBy(xpath="//a[text()='SDET3']")
	private WebElement selectorg;

	public WebElement getSearchorgtxtfld() {
		return searchorgtxtfld;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getSelectorg() {
		return selectorg;
	}
	
	
	

}
