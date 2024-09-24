package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if(!driver.getTitle().equals("Test Login | Practice Test Automation")) {
            throw new IllegalStateException("This is not login page! Current page on the browser is: " + driver.getCurrentUrl());
        }
    }
    private final By txt_username = By.name("username");
    private final By txt_password = By.name("password");
    private final By btn_submit = By.id("submit");
    private final By label_login_successful = By.className("post-title");

    public void enterUsername(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(btn_submit).click();
    }

    public void checkLoginSuccessful() {
        driver.findElement(label_login_successful).getText().equals("Logged In Successfully");
    }
}
