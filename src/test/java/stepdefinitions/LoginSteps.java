package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import pagefactory.HomePageFactory;
import pagefactory.LoginPageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    LoginPageFactory loginPageFactory;
    HomePageFactory homePageFactory;

    WebDriver driver = null;

    @Before(order = 0)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Before(order = 1, value = "@Smoke")
    public void setup2() {
        System.out.println("inside setup2");
    }
    @Given("^user is on login page$")
    public void verifyLoginPage() {
        System.out.println("inside given");
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @When("^clicks on the login button$")
    public void clicks_on_the_login_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPageFactory.clickSubmit();
        Thread.sleep(2000);
    }

    @Then("^user is navigated to the home page$")
    public void user_is_navigated_to_the_home_page() {
        homePageFactory = new HomePageFactory(driver);
        homePageFactory.checkLoginSuccessful();
    }

    @When("^user enters the valid (.*) and (.*)$")
    public void userEntersTheValidUsernameAndPassword(String username, String password) {
        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.enterUsername(username);
        loginPageFactory.enterPassword(password);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("before every step");
    }
    @AfterStep
    public void afterStep() {
        System.out.println("after every step");
    }

    @Then("logout button should be displayed")
    public void logoutButtonShouldBeDisplayed() {
        System.out.println("logout is displayed");
    }
}
