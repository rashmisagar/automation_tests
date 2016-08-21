package cucumberTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class amazon_test {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

 @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.amazon.co.uk/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 @Test
  public void testAmazon() throws Exception {
    driver.get(baseUrl + "/");
    String i = driver.getTitle();
	System.out.println(i);
    driver.findElement(By.id("searchDropdownBox")).click();
    new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
    driver.findElement(By.cssSelector("option[value=\"search-alias=stripbooks\"]")).click();
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Game of Thrones");
    driver.findElement(By.id("issDiv0")).click();
    driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div[2]/a/h2")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=https://images-na.ssl-images-amazon.com/images/G/01/AUIClients/AmazonUI-2acde173b89c066d4293e6af1668cceb75bcf992._V2_.css#AUIClients/AmazonUI.rendering_engine-not-trident.secure.udp_amznjq_shim-true.min | ]]
    driver.findElement(By.id("add-to-cart-button")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=https://images-na.ssl-images-amazon.com/images/G/01/AUIClients/AmazonUI-2acde173b89c066d4293e6af1668cceb75bcf992._V2_.css#AUIClients/AmazonUI.rendering_engine-not-trident.secure.udp_amznjq_shim-true.min | ]]
    driver.findElement(By.id("hlb-view-cart-announce")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
