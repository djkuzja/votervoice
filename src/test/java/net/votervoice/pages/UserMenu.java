package net.votervoice.pages;

import net.votervoice.util.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenu {
    public UserMenu (){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="adminName")
    public WebElement userMenu;

    @FindBy(id = "logout")
    public WebElement logoutBtn;

    public void logout(){
        userMenu.click();
        logoutBtn.click();
    }
}
