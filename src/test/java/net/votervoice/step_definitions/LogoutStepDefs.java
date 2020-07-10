package net.votervoice.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.votervoice.pages.LoginPage;
import net.votervoice.pages.UserMenu;
import net.votervoice.util.ConfigurationReader;
import net.votervoice.util.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LogoutStepDefs {
    String loginTitle = ConfigurationReader.get("loginTitle");
    String homeTitle = ConfigurationReader.get("HomeTitle");
    String username = ConfigurationReader.get("username");
    String password = ConfigurationReader.get("password");
    LoginPage loginPage = new LoginPage();
    UserMenu userMenu = new UserMenu();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);

    @Given("I'm on Home page")
    public void i_m_on_Home_page() {
        loginPage.loginWithBtn(username, password);
        wait.until(ExpectedConditions.titleIs(homeTitle));
        assertTrue("Home page is not presented", homeTitle.equals(Driver.get().getTitle()));
    }

    @When("I select Logout bottom from User Menu")
    public void i_select_Logout_bottom_from_User_Menu() {
        userMenu.logout();
        assertTrue("Titles are not equals", loginTitle.equals(Driver.get().getTitle()));
    }
}
