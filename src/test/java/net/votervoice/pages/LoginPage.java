package net.votervoice.pages;

import com.github.javafaker.Faker;
import net.votervoice.util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "username")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//span[@au-target-id='41']")
    public WebElement errorMessage;

    @FindBy(xpath = "//form/input[@name='username']/following-sibling::div[1]")
    public WebElement loginMsg;

    @FindBy(xpath = "//form/input[@name='password']/following-sibling::div[1]")
    public WebElement passwordMsg;

    public void loginWithBtn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

//*[@id="contentarea"]/div/router-view/div/div/div[1]/div/form/div[1]
//*[@id="contentarea"]/div/router-view/div/div/div[1]/div/form/div[2]

}
