package Pack1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		//driver.get("https://www.Flipcart.com/");

		System.out.println("The title is: "+driver.getTitle());
		System.out.println("The title is: "+driver.getCurrentUrl());
		
		WebElement search=driver.findElement(By.id("APjFqb"));
        
		
	/*	System.out.println("The Page source is: "+driver.getPageSource());

		WebElement search=driver.findElement(By.id("APjFqb"));
		search.sendKeys("Software Testing Tools");
		search.submit();
		//driver.findElement(By.name("btnk")).click();
		
		driver.navigate().to("https://www.amazon.in");
		System.out.println("The title is: "+driver.getTitle());
		System.out.println("The title is: "+driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println("The title is: "+driver.getTitle());		
		System.out.println("The title is: "+driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("The title is: "+driver.getTitle());
		System.out.println("The title is: "+driver.getCurrentUrl()); */

	}

}
