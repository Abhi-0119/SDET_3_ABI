package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil
{
	WebDriver driver;

	public WebDriverUtil(WebDriver driver) 
	{
		this.driver=driver;
	}

	public void maximisewindow()
	{
		driver.manage().window().maximize();
	}

	public void pageloadtimeout() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void selectValuefromDD(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);

	}
	public void selectValuefromDD(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);

	}
	public void selectValuefromDD(String text,WebElement element)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void movetoelement(WebElement element) 
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void clickbyoffset(int xOffset,int yOffset) {
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).click();
	}
	public void rightclick() 
	{
		Actions act=new Actions(driver);
		act.contextClick();
	}
	public void rightclick(WebElement element) 
	{
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	public void switchtoframe(int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoframe(String id) {
		driver.switchTo().frame(id);
	}
	public void switchtoframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void acceptAlert() 
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert() 
	{
		driver.switchTo().alert().dismiss();
	}
	public void sendkeys(WebElement element,String keysTosend) 
	{
		element.sendKeys(keysTosend);
	}
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollbyPosition(int x, int y) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public void switchTowindow(String title) 
	{
		Set<String> winids = driver.getWindowHandles();
		for(String id: winids) 
		{
			String currenttitle=driver.switchTo().window(id).getTitle()	;
			if(currenttitle.contains(title)) 
			{
				break;
			}

		}
	}

}
