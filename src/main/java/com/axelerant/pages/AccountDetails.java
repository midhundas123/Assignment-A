package com.axelerant.pages;

import com.axelerant.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetails extends PageUtility {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"accountId\"]")
    WebElement value_AccountNumber;

    @FindBy(xpath = "//*[@id=\"accountType\"]")
    WebElement value_AccountType;

    @FindBy(xpath = "//*[@id=\"balance\"]")
    WebElement value_Balance;

    @FindBy(xpath = "//*[@id=\"availableBalance\"]")
    WebElement value_availableBalance;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]//input[@value='Open New Account']")
    WebElement btn_openNewAccount;

    public AccountDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getText_value_AccountNumber() {
        sleep(3000);
        waitForElementTobeVisible(driver,value_AccountNumber,15);
        return value_AccountNumber.getText();
    }

    public String getText_value_AccountType() {
        return value_AccountType.getText();
    }

    public String getText_value_Balance() {
        return value_Balance.getText();
    }

    public String getText_value_availableBalance() {
        return value_availableBalance.getText();
    }
}
