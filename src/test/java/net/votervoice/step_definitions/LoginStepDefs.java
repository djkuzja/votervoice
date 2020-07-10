package net.votervoice.step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.votervoice.pages.LoginPage;
import net.votervoice.util.ConfigurationReader;
import net.votervoice.util.Driver;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    String loginTitle = ConfigurationReader.get("loginTitle");
    String username = ConfigurationReader.get("username");
    String password = ConfigurationReader.get("password");
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
    Faker faker = new Faker();
    SoftAssertions softly = new SoftAssertions();

    @Given("I'm on the login page")
    public void i_m_on_the_login_page() {
        assertTrue("Titles are not equals", loginTitle.equals(Driver.get().getTitle()));
    }

    @When("I enter a valid credentials")
    public void i_enter_a_valid_credentials() {
        loginPage.loginWithBtn(username, password);
    }

    @Then("I see the page with the title")
    public void i_see_the_page_with_the_title(List pageTitle) {
        String page = pageTitle.get(0).toString();
        String expectedTitle = pageTitle.get(1).toString();
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertTrue(page + " page is not presented", expectedTitle.equals(Driver.get().getTitle()));
    }

    @When("I enter invalid credentials")
    public void i_enter_invalid_credentials() {
        String username = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.loginWithBtn(username, password);
    }

    @Then("I see error message")
    public void i_see_error_message(String errorMessage) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        assertEquals(errorMessage, loginPage.errorMessage.getText());
    }

    @When("I login with a blank username")
    public void i_login_with_a_blank_username() {
        loginPage.loginWithBtn("", password);
    }

    @When("I login with a blank password")
    public void i_login_with_a_blank_password() {
        loginPage.loginWithBtn(username, "");
    }

    @When("I login with a blank username and password")
    public void i_login_with_a_blank_username_and_password() {
        loginPage.loginWithBtn("", "");
    }

    @Then("I see {string}  {string}")
    public void i_see(String msg1, String msg2) {
        if (msg1.isEmpty() && !(msg2.isEmpty())) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.passwordMsg));
            softly.assertThat(msg2).as("Password error").isEqualTo(loginPage.passwordMsg.getText());
        } else if (msg2.isEmpty() && !(msg1.isEmpty())) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.loginMsg));
            softly.assertThat(msg1).as("Username error").isEqualTo(loginPage.loginMsg.getText());
        } else {
            wait.until(ExpectedConditions.visibilityOf(loginPage.loginMsg));
            wait.until(ExpectedConditions.visibilityOf(loginPage.passwordMsg));
            softly.assertThat(msg1).as("Username error").isEqualTo(loginPage.loginMsg.getText());
            softly.assertThat(msg2).as("Password error").isEqualTo(loginPage.passwordMsg.getText());
        }
        softly.assertAll();
    }
}
