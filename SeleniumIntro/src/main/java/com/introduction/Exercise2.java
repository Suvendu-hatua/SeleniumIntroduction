package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise2 {

	public static void main(String[] args) {
		// for valid Username and Password........

		// setting up Edge Driver

		WebDriverManager.edgedriver().setup();

		// creating instance of WebDriver

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

		String title = driver.getTitle();
		System.out.println(title);

		// entering email id
		driver.findElement(By.cssSelector("input#input-email")).sendKeys("iamsuvenduhatua@gmail.com");
		// entering password
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Suvendu@2024");

		driver.findElement(By.xpath("//input[@value='Login']")).click();

		System.out.println(driver.findElement(By.xpath("//div[@id='content']//h2[text()='My Account']")).getText());

	}

}
