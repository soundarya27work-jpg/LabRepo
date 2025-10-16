package Pack1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("alert('Welcome to JavaScript');");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)");

	}

}
