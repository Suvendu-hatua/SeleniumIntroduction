package com.introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationWithDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\GEZ4V7X\\Desktop\\Selenium Tutorial\\msedgedriver.exe");

		
		WebDriver driver=new EdgeDriver();
		
		String month="06";
		String day="15";
		String year="2027";
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		
		driver.findElement(By.xpath("//div[@class='react-calendar__decade-view__years']//button[text()='"+year+"']")).click();
		
		List<WebElement> allMonths=driver.findElements(By.tagName("abbr"));
		
		allMonths.get(Integer.valueOf(month)-1).click();
		
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		List<WebElement> dateComponents=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(WebElement web:dateComponents) {
			System.out.println(web.getAttribute("value"));
		}
	}

}
