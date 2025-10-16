package Pack1;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Lab8JUnitTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testCompleteFlow() {
        // Step 1: 
        String expectedTitle = "Your Store";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(expectedTitle, driver.getTitle());

        // Step 2: 
        WebElement desktopsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        desktopsMenu.click();

        WebElement macLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mac (1)")));
        macLink.click();

        // Step 3:
        WebElement macHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mac']")));
        Assert.assertEquals("Mac", macHeading.getText());

        // Step 4: 
        WebElement sortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-sort")));
        Select sortDropdown = new Select(sortElement);
        sortDropdown.selectByVisibleText("Name (A - Z)");

        // Step 5: 
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@onclick[contains(., 'cart.add')]]")));
        addToCartButton.click();

        // Step 6: 
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        searchBox.clear();
        searchBox.sendKeys("Monitors");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[class='btn btn-default btn-lg']")));
        searchButton.click();

        // Step 7: 
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));

        // Step 8: Clear search criteria
        WebElement searchCriteria = driver.findElement(By.name("search"));
        searchCriteria.clear();

        // Step 9: 
        WebElement descriptionCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("description")));
        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
        }

        WebElement searchAgainButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[type='button'][value='Search']")));
        searchAgainButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}