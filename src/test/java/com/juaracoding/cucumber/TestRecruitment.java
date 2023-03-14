package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.LoginPage;
import com.juaracoding.cucumber.pages.RecruitmentPage;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRecruitment {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static RecruitmentPage recruitment = new RecruitmentPage();
    public static LoginPage loginPage = new LoginPage();


    public TestRecruitment() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("User click menu Recruitment")
    public void user_click_menu_recruitment() {
        loginPage.loginAdmin("Admin", "admin123");
        recruitment.setClickRecruitment();
        extentTest.log(LogStatus.PASS, "User click menu Recruitment");
    }

    @And("User click add button")
    public void user_click_add_button() {
        recruitment.addButton();
        extentTest.log(LogStatus.PASS, "User click add button");
    }

    @Then("User go to page Recruitment")
    public void user_go_to_page_recruitment() {
        Assert.assertEquals(recruitment.getTxtRecruitment(), "Recruitmentttttt");
        Hooks.delay();
        extentTest.log(LogStatus.PASS, "Admin go to page Recruitment");
    }


}
