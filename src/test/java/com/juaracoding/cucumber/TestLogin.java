package com.juaracoding.cucumber;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import com.juaracoding.cucumber.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();

    }

    @Given("User open browser and url")
    public void user_open_browser_and_url() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("User open browser and url");
    }

    @When("User enter valid username")
    public void user_enter_valid_username() {
        loginPage.enterUsername("Admin");
        System.out.println("User enter valid username");
    }


    @And("User enter valid password")
    public void user_enter_valid_password() {
        loginPage.enterPassword("admin123");
        System.out.println("User enter valid password");

    }

    @And("User click button login")
    public void user_click_button_login() {
        loginPage.buttonClick();
        delay(2);
        System.out.println("User click button login");
    }

    @Then("user go to page Dashboard")
    public void user_go_to_page_dashboard() {
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        delay(2);
        System.out.println("user go to page Dashboard");
    }

    @When("User click button logout")
    public void user_click_button_logout() {
        loginPage.buttonLogout();
        System.out.println("User click button logout");
        delay(2);
    }

    @And("User enter invalid username")
    public void user_enter_invalid_username() {
        loginPage.enterUsername("Adminaa");
        System.out.println("User enter invalid username");
    }


    @And("User enter invalid password")
    public void user_enter_invalid_password() {
        loginPage.enterPassword("admin123");
        System.out.println("User enter invalid password");

    }

    @Then("user get message invalid credentials")
    public void user_get_message_invalid_credentials() {
        Assert.assertEquals(loginPage.getTxtInvalidCredentials(), "Invalid credentials");
        delay(2);
        System.out.println("user get message invalid credentials");
    }

    @And("User no input password")
    public void user_no_input_password() {
//        loginpage.enterPassword("");
        System.out.println("User no input password");
    }

    @Then("user get message Required")
    public void user_get_message_required() {
        Assert.assertEquals(loginPage.getTxtRequired(), "Required");
        System.out.println("user get message Required");
    }


    @AfterAll
    public static void quitBrowser() {
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    static void delay(long second) {
        System.out.println("Delay");
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
