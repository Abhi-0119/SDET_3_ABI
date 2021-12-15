package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMClasses.CreateOrgPage;
import com.Vtiger.POMClasses.HomePage;
import com.Vtiger.POMClasses.OrgInfoPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtil;

public class TC001_CreateOrganizationTest extends BaseClass
{

	@Test(groups="smokeTest" , retryAnalyzer = com.Vtiger.genericUtil.RetryAnalyzer.class)
	public void createOrg() {
		//Click on org and create org
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		String Orgname=JavaUtil.objforJavaUtil().getFirstName()+JavaUtil.objforJavaUtil().generateRandomNumber();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getcreateorgnametxtfld().sendKeys(Orgname);

		//Save org
		cop.getSaveorgbtn().click();

		//refresh
		driver.navigate().refresh();
		hp.getOrglink().click();


		//Validating
		orginfopage.searchfororg(Orgname, "Organization Name");

		WebElement orgname=null;

		orgname	=driver.findElement(By.xpath("//a[text()='"+Orgname+"' and @title='Organizatio']"));
		System.out.println(orgname.isDisplayed());
		String actual=orgname.getText();
		Assert.assertEquals(Orgname, actual);

	}

	@Test(groups="RegressionTest" , retryAnalyzer = com.Vtiger.genericUtil.RetryAnalyzer.class)
	public void createorgwithphonenumber() 
	{
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrgInfoPage orginfopage = new OrgInfoPage(driver);
		orginfopage.getCreateorgimg().click();

		String Orgname=JavaUtil.objforJavaUtil().getFirstName()+JavaUtil.objforJavaUtil().generateRandomNumber();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getcreateorgnametxtfld().sendKeys(Orgname);

		String phonenumbr=JavaUtil.objforJavaUtil().getphonemunber();
		cop.getPhonenumberfld().sendKeys(phonenumbr);

		//Save org
		cop.getSaveorgbtn().click();

		//refresh
		driver.navigate().refresh();
		hp.getOrglink().click();


		//Validating
		orginfopage.searchfororg(phonenumbr, "Phone");

		WebElement orgname=null;
		orgname	=driver.findElement(By.xpath("//a[text()='"+Orgname+"' and @title='Organizations']"));
		System.out.println(orgname.isDisplayed());

		String actual=orgname.getText();

		Assert.assertEquals(Orgname, actual);
	}
}
