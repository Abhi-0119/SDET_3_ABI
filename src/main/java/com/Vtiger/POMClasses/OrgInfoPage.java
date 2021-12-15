package com.Vtiger.POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class OrgInfoPage 
{
	WebDriver driver;
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgimg;

	@FindBy(name="search_text")
	private WebElement searchfororgtxtfld;

	@FindBy(id="bas_searchfield")
	private WebElement searchfororgDD;

	@FindBy(name="submit")
	private WebElement searchNowbtn;

	public WebElement getCreateorgimg() {
		return createorgimg;
	}

	public WebElement getSearchfororgtxtfld() {
		return searchfororgtxtfld;
	}

	
	public WebElement getSearchfororgDD() {
		return searchfororgDD;
	}

	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}


	public OrgInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchfororg(String orgnamesearchfor,String text)
	{
		searchfororgtxtfld.sendKeys(orgnamesearchfor);
		WebDriverUtil util= new WebDriverUtil(driver);
		util.selectValuefromDD(text, searchfororgDD);
		searchNowbtn.click();
	}
}
