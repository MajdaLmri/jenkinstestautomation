import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class googleTest extends TestCase {
    public String baseUrl = "https://www.google.com/";
    String driverPath = "/Users/majdalaamai/IdeaProjects/AutoTest1/src/test/resources/chromedriver";
    public WebDriver driver ;

    @BeforeTest
    public void setup(){
        System.out.println("launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(enabled = false, priority=1)
    public void verifyHomepage() {
        Assert.assertEquals(true, driver.findElement(By.id("hplogo")).isDisplayed());

    }

    @Test (priority=0)
    public void verifyHomepageTitle() {
        Assert.assertEquals(true, driver.getTitle().equals("Google"));

    }

    @AfterTest
    public void teardown(){
        System.out.println("test passed");
        driver.close();
    }

}
