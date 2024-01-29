package com.introduction;

import javax.xml.transform.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// setting up WebDriver Manager
		WebDriverManager.edgedriver().setup();

		// creating an instance of WebDriver
		WebDriver driver = new EdgeDriver();

		String username="Suvendu_Hatua";
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("suvendu123");
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();

		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		String password = getPassword(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());

		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
		
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']//h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']//h2")).getText(), "Hello "+username+",");
		
		driver.findElement(By.xpath("//div[@class='login-container']/child::button")).click();
	

	}

	public static String getPassword(String passwordText) {
		int i = passwordText.indexOf("'");
		int j = passwordText.lastIndexOf("'");

		return passwordText.substring(i + 1, j);
	}

}
