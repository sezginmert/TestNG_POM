package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebDriverUniversityPage {

    public WebDriverUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[text()='LOGIN PORTAL']")
    public WebElement loginButton;

    @FindBy(id = "text")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginClick;


}
