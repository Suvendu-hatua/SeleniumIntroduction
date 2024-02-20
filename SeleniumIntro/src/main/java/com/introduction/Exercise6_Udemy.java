package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise6_Udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// hitting the url.
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[.='Nested Frames']")).click();
		// moving to top frame.
		WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
		driver.switchTo().frame(topFrame);
		// moving to middle frame.
		WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
		driver.switchTo().frame(middleFrame);

		System.out.println(driver.findElement(By.id("content")).getText());

		driver.close();

	}

}
