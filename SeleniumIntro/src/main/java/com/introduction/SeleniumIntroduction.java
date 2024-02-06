package com.introduction;

import org.openqa.selenium.InsecureCertificateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello");

		//Microsoft Edge

		System.setProperty("webdriver.edge.driver", "C:\\Users\\GEZ4V7X\\Desktop\\Selenium Tutorial\\msedgedriver.exe");
		
//		WebDriverManager.edgedriver().setup();
		
		//creating instance of webdriver
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		
		//title of the web page
		String title=driver.getTitle();
		System.out.println(title);
		
		//current url of the web page
		String currentURL=driver.getCurrentUrl();
		System.out.println(currentURL);
		
//		driver.close();
		driver.quit();		
	}

}
