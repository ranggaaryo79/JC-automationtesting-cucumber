package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.LoginPage;
import com.juaracoding.cucumber.utils.Constans;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TestLogin {

    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static LoginPage loginPage = new LoginPage();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }


    @Given("User open browser and url")
    public void user_open_browser_and_url() {
        driver.get(Constans.URL);
        extentTest.log(LogStatus.PASS,"User open browser and url");
    }

    @When("User enter valid username")
    public void user_enter_valid_username() {
        loginPage.enterUsername("Admin");
        extentTest.log(LogStatus.PASS,"User enter valid username");
    }


    @And("User enter valid password")
    public void user_enter_valid_password() {
        loginPage.enterPassword("admin123");
        extentTest.log(LogStatus.PASS,"User enter valid password");

    }

    @And("User click button login")
    public void user_click_button_login() {
        loginPage.buttonClick();
        Hooks.delay();
        extentTest.log(LogStatus.PASS,"User click button login");
    }

    @Then("user go to page Dashboard")
    public void user_go_to_page_dashboard() {
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        Hooks.delay();
        extentTest.log(LogStatus.PASS,"user go to page Dashboard");
    }

    @When("User click button logout")
    public void user_click_button_logout() {
        loginPage.buttonLogout();
        extentTest.log(LogStatus.PASS,"User click button logout");
        Hooks.delay();
    }

    @And("User enter invalid username")
    public void user_enter_invalid_username() {
        loginPage.enterUsername("Adminaa");
        extentTest.log(LogStatus.PASS,"User enter invalid username");
    }


    @And("User enter invalid password")
    public void user_enter_invalid_password() {
        loginPage.enterPassword("admin123");
        extentTest.log(LogStatus.PASS,"User enter invalid password");

    }

    @Then("User get message invalid credentials")
    public void user_get_message_invalid_credentials() {
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Invalid credentials");
        extentTest.log(LogStatus.PASS,"user get message invalid credentials");
        Hooks.delay();
    }

    @And("User no input password")
    public void user_no_input_password() {
//        loginPage.enterPassword("");
        extentTest.log(LogStatus.PASS,"User no input password");
    }

    @Then("User get message Required")
    public void user_get_message_required() {
        Assert.assertEquals(loginPage.getTxtRequired(), "Required");
        extentTest.log(LogStatus.PASS,"user get message Required");
    }


}
