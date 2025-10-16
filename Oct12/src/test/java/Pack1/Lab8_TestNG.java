package Pack1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.time.Duration;

public class Lab8_TestNG {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Reporter.log("Browser launched and navigated to TutorialsNinja demo site", true);
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String expectedTitle = "Your Store";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        Reporter.log("Verifying home page title: " + actualTitle, true);
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title mismatch");
    }

    @Test(priority = 2)
    public void navigateToMacSection() {
        WebElement desktopsMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops")));
        desktopsMenu.click();
        Reporter.log("Clicked on 'Desktops' tab", true);

        WebElement macLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mac (1)")));
        macLink.click();
        Reporter.log("Clicked on 'Mac' link", true);

        WebElement macHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Mac']")));
        Reporter.log("Verifying heading: " + macHeading.getText(), true);
        Assert.assertEquals(macHeading.getText(), "Mac", "Mac heading not found");
    }

    @Test(priority = 3)
    public void sortAndAddToCart() {
        WebElement sortElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-sort")));
        Select sortDropdown = new Select(sortElement);
        sortDropdown.selectByVisibleText("Name (A - Z)");
        Reporter.log("Selected 'Name (A - Z)' from Sort By dropdown", true);

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@onclick[contains(., 'cart.add')]]")));
        addToCartButton.click();
        Reporter.log("Clicked on 'Add to Cart' button", true);
    }

    @Test(priority = 4)
    public void searchMonitorsAndRefine() {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        Reporter.log("Entered 'Monitors' in search box", true);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[class='btn btn-default btn-lg']")));
        searchButton.click();
        Reporter.log("Clicked on 'Search' button", true);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("content")));
        Reporter.log("Search results loaded", true);

        WebElement searchCriteria = driver.findElement(By.name("search"));
        searchCriteria.clear();
        Reporter.log("Cleared search criteria", true);

        WebElement descriptionCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("description")));
        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
            Reporter.log("Checked 'Search in product descriptions'", true);
        }

        WebElement searchAgainButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[type='button'][value='Search']")));
        searchAgainButton.click();
        Reporter.log("Clicked on 'Search' button again", true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            Reporter.log("Browser closed", true);
        }
    }
}
