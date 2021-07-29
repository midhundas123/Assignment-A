package com.axelerant.pages;

import com.axelerant.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccount extends PageUtility {

    WebDriver driver;
    @FindBy(xpath = "//select[@id=\"type\"]")
    WebElement accountType;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]//h1")
    WebElement message_AccountOpened;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]//*[text()=\"Congratulations, your account is now open.\"]")
    WebElement message_Congrats;

    @FindBy(xpath = "//*[text()=\"Your new account number:\"]")
    WebElement message_YourNewAccountNumber;

    @FindBy(xpath = "//*[@id=\"type\"]")
    WebElement accountType_CHECKING;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]//input[@value='Open New Account']")
    WebElement btn_openNewAccount;

    @FindBy(xpath = "//*[@id=\"newAccountId\"]")
    WebElement txt_accountNumber;


    public OpenNewAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String openSavingsAccount() {
        waitForJSandJQueryToLoad(driver);
        try {
            selectByVisibleText(driver,accountType,"SAVINGS");
        } catch (Exception e) {
            System.out.println("printing");
            e.printStackTrace();
        }
        clickOnOpenNewAccount();
        return getAccountNumber();
    }

    public String openCheckingAccount() {
        waitForJSandJQueryToLoad(driver);
        try {
            selectByVisibleText(driver,accountType,"CHECKING");
        } catch (Exception e) {
            System.out.println("printing");
            e.printStackTrace();
        }
        clickOnOpenNewAccount();
        return getAccountNumber();
    }

    public String getAccountNumber() {
        waitForElementTobeVisible(driver, txt_accountNumber, 15);
        return txt_accountNumber.getText();
    }

    public void clickOnOpenNewAccount() {
        sleep(7000);
        try {
            //waitForJSandJQueryToLoad(driver);
            //waitForElementTobeVisible(driver, btn_openNewAccount, 15);
            //clickWithJS(driver,btn_openNewAccount);
            btn_openNewAccount.click();
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAccountOpened() {
        waitForElementTobeVisible(driver, message_AccountOpened, 15);;
        return message_AccountOpened.getText().equals("Account Opened!")&&message_YourNewAccountNumber.isDisplayed()&&message_Congrats.isDisplayed();
    }

    public AccountDetails clickOnAccount() {
        waitForElementTobeVisible(driver, txt_accountNumber, 15);
        txt_accountNumber.click();
        return new AccountDetails(driver);
    }





}
