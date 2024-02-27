package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise8_Udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriverManager.edgedriver().setup();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\GEZ4V7X\\Desktop\\Selenium Tutorial\\msedgedriver.exe");

		WebDriver driver=new EdgeDriver();
		//hitting the specific url.
		driver.get("http://qaclickacademy.com/practice.php");
		
		//count the no of rows and no of columns.
		System.out.println(driver.findElements(By.xpath("//table[@name='courses']//tbody//tr")).size());
		
		System.out.println(driver.findElements(By.xpath("//table[@name='courses']//tbody//tr[1]//th")).size());
	}

}
