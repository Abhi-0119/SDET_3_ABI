package com.Vtiger.genericUtil;

import java.util.Random;

import com.github.javafaker.Faker;


public class JavaUtil 
{
	
	private JavaUtil()
	{
		
	}
	
	public static JavaUtil objforJavaUtil()
	{
		JavaUtil jv= new JavaUtil();
		return jv;
	}
	
	/**
	 * @author AMAR-G
	 * Descpritation : This method generate random number
	 * 
	 * @return random number
	 */

	public int generateRandomNumber()
	{
		Random r = new Random();

		return r.nextInt(1000);

	}

	/**@author AMAR-G
	 * Description : Generate random name
	 * 
	 * 
	 * @return random name
	 */

	public String getFullName() 
	{
		Faker faker = new Faker();
		return	faker.name().fullName();
	}
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() 
	{
		Faker faker = new Faker();
		return	faker.name().firstName();
	}
	/**
	 * 
	 * @return lastName
	 */
	public String getlastName() 
	{
		Faker faker = new Faker();
		return	faker.name().lastName();
	}
	public String getphonemunber() 
	{
		Faker faker = new Faker();
		return	faker.phoneNumber().cellPhone();
	}
	

}
