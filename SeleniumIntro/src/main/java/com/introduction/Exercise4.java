package com.introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.manage().window().maximize();
		// hitting the url.
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		System.out.println(driver.getTitle());

		loginToApplication(driver, wait);
		
		addProductsToCart(driver, wait);
		
		//checkout cart.
		driver.findElement(By.cssSelector("a.btn-primary")).click();
		
		performCheckOut(driver, wait);
		
		performPurchase(driver, wait);
		
		System.out.println(driver.findElement(By.cssSelector(".alert strong")).getText());
		
		driver.quit();
	}
	
	public static void addProductsToCart(WebDriver driver,WebDriverWait wait) {
		//wait until all the products to be displayed.
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("app-card-list.row")));
		
		//adding all the products to cart.
		List<WebElement> cartButtons=driver.findElements(By.xpath("//div[@class='card-footer']//button"));
		for(WebElement el:cartButtons) {
			el.click();
		}
	}
	

	public static void loginToApplication(WebDriver driver, WebDriverWait wait) {
		// login functionality
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[normalize-space()='User']")).click();

		// handing pop up.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-confirm")));
		System.out.println(driver.findElement(By.cssSelector("div.modal-body p")).getText());
		driver.findElement(By.id("okayBtn")).click();

		// working the Static DropDowns.
		Select select = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		select.selectByIndex(2);

		// selecting checkbox
		driver.findElement(By.id("terms")).click();

		// submitting form
		driver.findElement(By.id("signInBtn")).click();
	}
	
	public static void performCheckOut(WebDriver driver,WebDriverWait wait) {
		//wait untill all the items to be displayed.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']//div[@class='row']")));
		driver.findElement(By.cssSelector("button.btn-success")).click();
	}
	
	public static void performPurchase(WebDriver driver,WebDriverWait wait) {
		//wait until the text is visible.
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("label[for='country']")));
		driver.findElement(By.id("country")).sendKeys("india");
		
		//wait until all the options is to be displayed.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions")));
		driver.findElement(By.xpath("//div[@class='suggestions']//a")).click();
		
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("document.getElementById('checkbox2').click()");
//		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}
