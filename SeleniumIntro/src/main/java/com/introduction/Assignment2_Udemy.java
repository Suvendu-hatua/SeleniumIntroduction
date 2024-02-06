package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_Udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//form//input[@name='name']")).sendKeys("Suvendu Hatua");
		driver.findElement(By.xpath("//form//input[@name='email']")).sendKeys("suvendu@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("suvendu@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement select=driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select ss=new Select(select);
		ss.selectByIndex(0);
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//form//input[@type='date']")).sendKeys("01/30/2023");
		
		driver.findElement(By.xpath("//form//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

	}

}
