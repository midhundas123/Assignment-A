package com.axelerant.pages;

import com.axelerant.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageUtility {

    WebDriver driver;

    @FindBy(xpath = "//*[text()='Open New Account']")
    WebElement openNewAccount;

    @FindBy(xpath = "//*[@id=\"topPanel\"]/a[2]/img")
    WebElement logo;

    @FindBy(xpath = "//a[text()='Bill Pay']")
    WebElement billPay;

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getHomePageLoadedElement() {
        waitForElementTobeVisible(driver, logo, 15);
        return logo;
    }

    public OpenNewAccount clickOnOpenNewAccount() {
        waitForElementTobeVisible(driver, openNewAccount, 15).click();
        return new OpenNewAccount(driver);
    }

    public BillPayment clickOnBillPay() {
        waitForElementTobeVisible(driver, billPay, 15).click();
        return new BillPayment(driver);
    }


}
