package com.introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise5_Udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		//hitting the url.
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//a[.='Click Here']")).click();
		
		//getting all the window handles.
		Set<String>windows=driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		
		//moving to child window.
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		//moving to parent window.
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		//closing all the opened windows and all the sessions.
		driver.quit();

	}

}
