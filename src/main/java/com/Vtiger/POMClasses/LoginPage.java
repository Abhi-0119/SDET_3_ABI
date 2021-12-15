package com.Vtiger.POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.FileUtil;

public class LoginPage // Rule 1
{
	WebDriver driver;
	
	@FindBy(name="user_name") //Rule 2
	private WebElement username; //Rule 3
	
	
	@FindBy(name="user_password") //Rule 2
	private WebElement password; //Rule 3
	
	
	@FindBy(id="submitButton") //Rule 2
	private WebElement loginbtn; //Rule 3


	public WebElement getUsername() //Rule 4
	{
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public LoginPage(WebDriver driver)  //Rule 5
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logintoApp() throws IOException  //Rule 6
	{
		username.sendKeys(FileUtil.objforfileutil().readDatafromPropfile("username"));
		password.sendKeys(FileUtil.objforfileutil().readDatafromPropfile("password"));
		loginbtn.click();
	}
	
	public void logintoApp(String newusername,String newpassword)  //Rule 6
	{
		username.sendKeys(newusername);
		password.sendKeys(newpassword);
		loginbtn.click();
	}
	
}
