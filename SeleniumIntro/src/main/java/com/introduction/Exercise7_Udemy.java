package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise7_Udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("checkBoxOption2")).click();
		String optionText=driver.findElement(By.xpath("//input[@id='checkBoxOption2']//parent::label")).getText();
		
		//selecting DropDown by dynamic text.
		
		Select select=new Select(driver.findElement(By.id("dropdown-class-example")));
		select.selectByVisibleText(optionText);
		
		//working with AlertBox.
		driver.findElement(By.id("name")).sendKeys(optionText);
		driver.findElement(By.id("alertbtn")).click();
		
//		System.out.println(driver.switchTo().alert().getText());
		String msg=driver.switchTo().alert().getText();
		String match=msg.split(",")[0].split(" ")[1];
		Assert.assertEquals(match, optionText);
		driver.switchTo().alert().accept();
		
//		System.out.println(optionText);
		driver.quit();

	}

}
