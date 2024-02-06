package com.introduction;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		WebDriverManager.edgedriver().setup();

		System.setProperty("webdriver.edge.driver", "C:\\Users\\GEZ4V7X\\Desktop\\Selenium Tutorial\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());

		// clicking Radio button
		driver.findElement(By.xpath("//input[@value='radio1']")).click();

		// searching by value
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> dropdowns = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for (WebElement dd : dropdowns) {
			if (dd.getText().equalsIgnoreCase("India")) {
				dd.click();
				break;
			}
		}

		// working with dropdown box
		WebElement options = driver.findElement(By.id("dropdown-class-example"));

		Select ss = new Select(options);
		ss.selectByIndex(1);

		// working with CheckBox
		driver.findElement(By.id("checkBoxOption1")).click();
		driver.findElement(By.id("checkBoxOption3")).click();

		// Open window and switch to new window

		driver.findElement(By.id("openwindow")).click();

		List<String> allHandles = new ArrayList<String>(driver.getWindowHandles());

		for (String val : allHandles) {
			System.out.println(val);
		}

		driver.switchTo().window(allHandles.get(1));
		driver.manage().window().maximize();

		driver.switchTo().window(allHandles.get(0));

//		Open tab and switch to new tab
		Thread.sleep(2000);

		driver.findElement(By.id("opentab")).click();

		ArrayList<String> ll = new ArrayList<String>(driver.getWindowHandles());

		for (String val : ll) {
			System.out.println(val);
		}

		driver.switchTo().window(ll.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();

		driver.switchTo().window(ll.get(0));
		System.out.println(driver.getCurrentUrl());

//		working with Alert
		driver.findElement(By.id("name")).sendKeys("Suvendu");
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		// working with Confirm box
		driver.findElement(By.id("name")).sendKeys("Suvendu");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Name of the courses with price 25
		
		List<WebElement>courses=driver.findElements(By.xpath("//table[@id='product']//td[contains(text(),25)]/preceding-sibling::td[1]"));	
		System.out.println("**********courses whose price 25************");
		for(WebElement element:courses) {
			System.out.println(element.getText());
		}
		
//		 Mouse Hover and select “Reload”
		
		WebElement ele=driver.findElement(By.id("mousehover"));
		
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Reload")).click();		
		

	}

}
