package com.juaracoding.cucumber;

import com.juaracoding.cucumber.drivers.DriverSingleton;

import com.juaracoding.cucumber.utils.Constans;
import com.juaracoding.cucumber.utils.TestScenarios;
import com.juaracoding.cucumber.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public static void setUp() {
        DriverSingleton.getInstance(Constans.CHROME);
        driver = DriverSingleton.getDriver();
        TestScenarios[] test = TestScenarios.values();
        extentTest = reports.startTest(test[Utils.testCount].getTestCastName());
        Utils.testCount++;
    }

    @After
    public void endTestCase() {
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ", "_"));
            extentTest.log(LogStatus.FAIL, scenario.getName() + "\n" + extentTest.addScreenCapture(screenshotPath));
        }
    }

    @AfterAll
    public static void quitBrowser() {
        delay();
        DriverSingleton.closeObjectInstance();
    }

    static void delay() {
        System.out.println("Delay");
        try {
            Thread.sleep(Constans.SECOND * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
