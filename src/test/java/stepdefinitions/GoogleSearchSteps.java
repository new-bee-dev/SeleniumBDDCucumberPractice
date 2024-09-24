package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {
    WebDriver driver = null;
    @Given("google homepage is open in the web browser")
    public void google_homepage_is_open_in_the_web_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        
    }

    @When("user enters the search string in the textbox")
    public void user_enters_the_search_string_in_the_textbox() {
        driver.findElement(By.name("q")).sendKeys("Automation Practice");
    }

    @When("hits the search button")
    public void hits_the_search_button() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        driver.getPageSource().contains("Automation Practice");
        driver.close();
        driver.quit();
    }
}
