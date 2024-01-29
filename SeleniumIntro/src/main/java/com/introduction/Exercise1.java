package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setting up Edge Driver
		
		WebDriverManager.edgedriver().setup();
		
		//creating instance of WebDriver
		
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.cssSelector("input#input-email")).sendKeys("suvendu@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("suvendu");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-danger alert-dismissible')]")).getText());
		
		driver.findElement(By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("suvedu01@gmail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
	}

}
