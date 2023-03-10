package com.juaracoding.cucumber.pages;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    private WebDriver driver;

    public RecruitmentPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    WebElement clickRecruitment;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement add;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    WebElement vacancy;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement contact;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement doc;
    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    WebElement keyword;
    @FindBy(xpath = "//input[@placeholder='yyyy-mm-dd']")
    WebElement date;
    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    WebElement note;
    @FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement checkBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement save;


    public void rec() {

        clickRecruitment.click();
        add.click();

        firstName.sendKeys("Juara");
        middleName.sendKeys("Coding");
        lastName.sendKeys("Bootcamp");
        vacancy.sendKeys("Sofware");
        email.sendKeys("juaracoding@test.com");
        contact.sendKeys("12345");
        String pathDoc = "D:\\New DOCX Document.docx";
        doc.sendKeys(pathDoc);
        keyword.sendKeys("Test");
        date.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        date.sendKeys("2023-02-23");
        note.sendKeys("Test");
        checkBox.click();
        save.click();

    }

}
