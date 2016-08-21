package stepDefinition;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonTest_steps {
	public static WebDriver driver;	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	  
	@Given("^Browser is open$")
	public void browser_is_open() throws Throwable {
		driver = new FirefoxDriver();
        driver.manage().window().maximize();

	}

	@When("^User Navigates to Amazon Page$")
	public void user_Navigates_to_Amazon_Page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.amazon.co.uk/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^Amazon Page is open$")
	public void amazon_Page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//get title and verify
		driver.findElement(By.id("searchDropdownBox")).isDisplayed();
		String s = "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";
		assert (driver.getTitle().equals(s));

	}
	
	@When("^I navigate to books section$")
	public void i_navigate_to_books_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("searchDropdownBox")).click();
	    new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Books");
	    driver.findElement(By.cssSelector("option[value=\"search-alias=stripbooks\"]")).click();
	
	}
	
	@When("^I enter \"([^\"]*)\" in the Search field$")
	public void i_enter_in_the_Search_field(String arg1) throws Throwable {
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(arg1);
	    driver.findElement(By.id("issDiv0")).click();
	  
	}
	
	@Then("^The search results are shown$")
	public void the_search_results_are_shown() throws Throwable {
		isTextPresent("results for Books : 'game of thrones'");

	}

	@Then("^first item has the title \"([^\"]*)\"$")
	public void first_items_has_the_title(String arg1) throws Throwable {
		assert (driver.findElement(By.className("s-access-title")).getText().equals(arg1));
	}

	@Then("^It has a badge \"([^\"]*)\"$")
	public void it_has_a_badge(String arg1) throws Throwable {
		isTextPresent(arg1);
		assert (driver.findElement(By.className("a-size-small s-inline-block s-color-white sx-bestseller-badge")).getText().equals(arg1));

	}

	@Then("^Selected type is \"([^\"]*)\"$")
	public void selected_type_is(String arg1) throws Throwable {
		assert (driver.findElement(By.className("a-size-small a-color-null s-inline    a-text-normal")).getText().equals(arg1));

	}

	@Then("^price is \"([^\"]*)\"$")
	public void price_is(String arg1) throws Throwable {
		isTextPresent(arg1);

	}


	@When("^I navigate to the book details$")
	public void i_navigate_to_the_book_details() throws Throwable {
		WebElement firstItem = driver.findElement(By.className("s-access-title"));
		firstItem.click();


	}

	@Then("^title is shown as \"([^\"]*)\"$")
	public void title_is_shown_as(String arg1) throws Throwable {
		assert (driver.findElement(By.className("s-access-title")).getText().equals(arg1));

	}

	@Then("^badge is \"([^\"]*)\"$")
	public void badge_is(String arg1) throws Throwable {
		isTextPresent(arg1);
		assert (driver.findElement(By.className("badge-link")).getText().equals(arg1));

	}


	@Then("^type is \"([^\"]*)\"$")
	public void type_is(String arg1) throws Throwable {
		assert (driver.findElement(By.className("a-button-text")).getText().equals(arg1));

	}

	@Given("^Add button is shown$")
	public void Add_button_is_shown() throws Throwable {
		driver.findElement(By.id("add-to-cart-button")).isDisplayed();

	}

	@When("^I Add the book to the basket$")
	public void i_Add_the_book_to_the_basket() throws Throwable {
		driver.findElement(By.id("add-to-cart-button")).click();
	
	}

	@Then("^Notification is shown$")
	public void notification_is_shown() throws Throwable {
		driver.findElement(By.id("huc-v2-order-row-inner")).isDisplayed();

	 
	}

	@Then("^the title is Added to Basket$")
	public void the_title_is_Added_to_Basket() throws Throwable {
		assert (driver.findElement(By.id("huc-v2-order-row-confirm-text")).getText().equals("Added to Basket"));
	
	}

	@Then("^quantity is \"([^\"]*)\"$")
	public void quantity_is(String arg1) throws Throwable {
		isTextPresent("Basket subtotal (1 item)");
	}



	@When("^I Click on edit the basket$")
	public void i_Click_on_edit_the_basket() throws Throwable {
		driver.findElement(By.id("hlb-view-cart-announce")).click();

	}

	@Then("^\"([^\"]*)\" is shown on the list$")
	public void the_book_is_shown_on_the_list(String arg1) throws Throwable {
		assert (driver.findElement(By.className("s-access-title")).getText().equals(arg1));

	}


	@Then("^total price is \"([^\"]*)\"$")
	public void total_price_is(String arg1) throws Throwable {
		assert (driver.findElement(By.className("sc-subtotal a-text-right a-float-right")).getText().equals(arg1));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	

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
	  
	protected boolean isTextPresent(String text){
		try{
			boolean b = driver.getPageSource().contains(text);
			return b;
		}
		catch(Exception e){
			return false;
		}
	}
	

}
