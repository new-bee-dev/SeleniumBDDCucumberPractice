package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
    WebDriver driver;
    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "post-title")
    WebElement label_login_success;

    public void checkLoginSuccessful() {
        label_login_success.getText().equals("Logged In Successfully");
    }

}
