package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Lab8TestNG {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        Reporter.log("Opened URL on Firefox", true);
    }

    @Test
    public void testLab3AndLab4Flow() {
        // Lab 4: Verify page title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Your Store", "Page title should match");
        Reporter.log("Verified page title: " + actualTitle, true);

        // Lab 3 & 4: Navigate to Desktops → Mac
        driver.findElement(By.linkText("Desktops")).click();
        Reporter.log("Clicked on 'Desktops' tab", true);

        driver.findElement(By.linkText("Mac")).click();
        Reporter.log("Clicked on 'Mac'", true);

        // Lab 4: Verify Mac heading
        Assert.assertTrue(driver.getPageSource().contains("Mac"), "Mac heading should be visible");
        Reporter.log("Verified 'Mac' heading", true);

        // Lab 3 & 4: Sort by Name (A-Z)
        Select sortDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortDropdown.selectByVisibleText("Name (A - Z)");
        Reporter.log("Selected 'Name (A-Z)' from 'Sort By' dropdown", true);

        // Lab 3 & 4: Click on Add to Cart
        driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
        Reporter.log("Clicked on 'Add to Cart' button", true);

        // Lab 4: Search for 'Monitors'
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Monitors");
        driver.findElement(By.cssSelector("button.btn-default")).click();
        Reporter.log("Searched for 'Monitors'", true);

        // Lab 4: Clear and search in product descriptions
        WebElement descriptionBox = driver.findElement(By.id("description"));
        descriptionBox.clear();
        descriptionBox.click();
        driver.findElement(By.id("button-search")).click();
        Reporter.log("Clicked on 'Search in product descriptions' checkbox and searched again", true);

        // Final verification (optional)
        Assert.assertTrue(driver.getPageSource().contains("Search"), "Search results should be displayed");
        Reporter.log("Verified search results are displayed", true);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        Reporter.log("Browser closed", true);
    }
}