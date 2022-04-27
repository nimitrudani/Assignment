package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = null;
	int flipkartPrice = 0, amazonPrice = 0;
	List<WebElement> projectname = new ArrayList<WebElement>();

	@Given("{string} browser is open")
	public void browser_is_open(String browserName) {
		driver = SetAndOpenBrowser(browserName);
	}

	@And("user navigates to {string}")
	public void user_navigates_to(String url) {
		driver.get(url);
	}

	@When("user selects {string} from drop-down")
	public void user_selects_from_drop_down(String value) {
		/* closing cookies accept box */
		WebElement cookiesAgreeBtn = driver.findElement(By.xpath("/html/body/generic-ui-root/gw-cookies/div/button"));
		cookiesAgreeBtn.click();

		/* dropdown to select "100" */
		WebElement dropDown = driver.findElement(
				By.xpath("/html/body/generic-ui-root/gw-demo-root/main/gw-demo-project/gui-select/div/div"));
		dropDown.click();

		/*
		 * selecting relative xpath, so if we have 1000 from FF we need not to write
		 * another code
		 */
		WebElement valueEle = driver
				.findElement(By.xpath("//div[@class ='gui-option'] [text() = ' " + value + " Rows ']"));
		valueEle.click();
	}

	@Then("user is able to see {string} rows in the grid table")
	public void user_is_able_to_see_rows_in_the_grid_table(String expCount) throws AWTException {
		// List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,
		// 'gui-row gui-structure-row')]"));
		/*
		 * Need to do some R&D on AG Grid automation, for time being assuming count
		 * showing on UI is accurate
		 */
//
//		WebElement id  = driver.findElement(By.xpath("//span[@class='gui-cell-number'][text()=' 1 ']"));
//		id.click();
		
//		Robot robot = new Robot();
//		for(int i =0 ;i<=20;i++) {
//			
//			robot.keyPress(KeyEvent.VK_DOWN);
//			robot.keyRelease(KeyEvent.VK_DOWN);
//			projectname.add(driver.findElement(By.xpath("")));
//		}
		
		
		WebElement countFromUI = driver.findElement(By.xpath("//*[@id=\"gui-grid-1\"]/div[1]/div[7]/div[1]/div/b"));
		System.out.println("Expected: " + expCount);
		System.out.println("Actual: " + countFromUI.getText());

		Assert.assertEquals("Count Mismatched.!!", expCount, countFromUI.getText());
	}
	
	 @And("^get the below data from grid where project status is active$")
	    public void get_the_below_data_from_grid_where_project_status_is_active(List<String> columns) throws Throwable {
		 System.out.println(columns.toString());
	    }

	@When("user search for {string} on {string}")
	public void user_search_for_on_flipkart(String searchStr, String website) throws InterruptedException {
		WebElement searchBox = null, btnSearch = null;
		/* Getting search box and search button locators */
		if (website.equalsIgnoreCase("amazon")) {
			searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			btnSearch = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

		} else if (website.equalsIgnoreCase("flipkart")) {
			/* for flipkart.getting login/signup box, closing that */
			WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
			close.click();
			Thread.sleep(2000);
			searchBox = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
			btnSearch = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));

		}

		searchBox.click();
		searchBox.sendKeys(searchStr);
		btnSearch.click();
		Thread.sleep(5000);
	}
	
	@And("change the display price to INR")
	public void change_the_display_price_to_inr() throws InterruptedException{
		WebElement btnPrice = driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[2]"));
		btnPrice.click();
		
		WebElement priceDropdown = driver.findElement(By.xpath("//*[@id=\"icp-currency-dropdown-selected-item-prompt\"]/span/span"));
		priceDropdown.click();
		
		WebElement inr = driver.findElement(By.xpath("//*[@id=\"icp-currency-dropdown_44\"]/span"));
		inr.click();
		
		/* clicking on save button */
		driver.findElement(By.xpath("//*[@id=\"icp-save-button\"]/span/input")).click();
		
		Thread.sleep(5000);
		
	}

	@Then("user is  able to see price of that item on {string}")
	public void user_is_able_to_see_price_of_that_item_on_flipkart(String website) {
		/* to get list of all names and price */
		List<WebElement> nameTxt = null;
		List<WebElement> priceTxt = null;
		int i = 0;

		if (website.equalsIgnoreCase("amazon")) {

			nameTxt = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			priceTxt = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

			/* if name is expected, fetch price for it else sysout not available */
			for (WebElement name : nameTxt) {
				if (name.getText().equals("APPLE iPhone 13 (Starlight, 256 GB)")) {
					amazonPrice = Integer.parseInt(priceTxt.get(i).getText().replace(",", ""));
					System.out.println("Price on Amazon: " + amazonPrice);
					break;
				} else {
					amazonPrice = 0;
				}
				i++;
			}

		} else if (website.equalsIgnoreCase("flipkart")) {
			nameTxt = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			priceTxt = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

			/* if name is expected, fetch price for it else sysout not available */
			for (WebElement name : nameTxt) {
				if (name.getText().equals("APPLE iPhone 13 (Starlight, 256 GB)")) {
					flipkartPrice = Integer.parseInt(priceTxt.get(i).getText().substring(1).replace(",", ""));
					System.out.println("Price on Flipkart: " + flipkartPrice);
					break;
				} else {
					flipkartPrice = 0;
				}
				i++;
			}
		}
	}

	@Then("user close the browser")
	public void user_close_the_browser() {

		driver.quit();
	}

	@Then("user compares the price and print the result")
	public void user_compares_the_price_and_print_the_result() {
		/* Printing final result */
		System.out.println(" ____________________________Result ____________________________");
		if ((amazonPrice < flipkartPrice) && amazonPrice != 0 && flipkartPrice != 0) {
			System.out.println("Price on Amazon is cheaper than Flipkart");

		} else if ((amazonPrice > flipkartPrice) && amazonPrice != 0 && flipkartPrice != 0) {
			System.out.println("Price on Flipkart is cheaper than Amazon");
		} else if (amazonPrice == 0) {
			System.out.println("NOT AVAILABLE ON AMAZON");
		} else if (flipkartPrice == 0) {
			System.out.println("NOT AVAILABLE ON FLIPKART");
		}

		System.out.println("Flipkart: " + flipkartPrice);
		System.out.println("Amazon: " + amazonPrice);
	}

	/**
	 * This function will set system properties and open browser according to name
	 * provided, for now supported chrome only, we can add multiple in switch-case
	 * 
	 * @param browserName
	 * @return WebDriver
	 */
	WebDriver SetAndOpenBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName.toLowerCase()) {
		case "chrome": {
			// Setting system properties of ChromeDriver
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
		default: {
			Assert.assertTrue("Invalid Browser Name..!! Acceptable values = [\"chrome\"]", false);
		}
		}

		return driver;
	}

}
