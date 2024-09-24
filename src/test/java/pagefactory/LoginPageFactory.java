package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LoginPageFactory {
    WebDriver driver;
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
//        AjaxElementLocatorFactory ajaxElementLocatorFactory = new AjaxElementLocatorFactory(driver, 30);
//        PageFactory.initElements(ajaxElementLocatorFactory, this);
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "username")
    WebElement txt_username;

    @FindBy(name = "password")
    WebElement txt_password;

    @FindBy(id = "submit")
    WebElement btn_submit;

    @FindBy(partialLinkText = "practicetestautomation")
    List<WebElement> links_practice;

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickSubmit() {
        btn_submit.click();
    }

    public void getAllPracticeLinks() {
        System.out.println("inside method");
        for(WebElement link : links_practice) {
            System.out.println(link);
        }
    }
}
