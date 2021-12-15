package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage 
{
	
	
	public CreateOrgPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement createorgnametxtfld;

	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement type;
	
	@FindBy(name="rating")
	private WebElement rating;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveorgbtn;
	
	@FindBy(id="phone")
	private WebElement phonenumberfld;
	
	
	public WebElement getPhonenumberfld() {
		return phonenumberfld;
	}

	public WebElement getcreateorgnametxtfld() {
		return createorgnametxtfld;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getSaveorgbtn() {
		return saveorgbtn;
	}
	
	
	
	
}
