package com.axelerant.pages;

import com.axelerant.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPayment extends PageUtility {

    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[1]/td[2]/input")
    WebElement value_PayeeName;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[2]/td[2]/input")
    WebElement value_Address;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[3]/td[2]/input")
    WebElement value_City;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[4]/td[2]/input")
    WebElement value_State;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[5]/td[2]/input")
    WebElement value_ZipCode;

    @FindBy(xpath = "//*[@name='payee.phoneNumber']")
    WebElement value_Phone;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[8]/td[2]/input")
    WebElement value_Account;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[9]/td[2]/input")
    WebElement value_VerifyAccount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[11]/td[2]/input")
    WebElement value_Amount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[13]/td[2]/select")
    WebElement value_FromAccount;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]//input[@value='Send Payment']")
    WebElement sendPayment;

    @FindBy(xpath = "//*[text()=\" was successful.\n" +
            "    \"]")
    WebElement PaymentSuccessMessage;


    public BillPayment(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void EnterBillPaymentDetails(String payeeName,String address,String City,String state,String zip,String ph,String acc,String verifyAcc,String amount,String fromAccountNo ) {
        waitForJSandJQueryToLoad(driver);
        value_PayeeName.sendKeys(payeeName);
        value_Address.sendKeys(address);
        value_City.sendKeys(City);
        value_State.sendKeys(state);
        value_ZipCode.sendKeys(zip);
        value_Phone.sendKeys(ph);
        value_Account.sendKeys(acc);
        value_VerifyAccount.sendKeys(verifyAcc);
        value_Amount.sendKeys(amount);
        selectFromAccount(fromAccountNo);
        clickOnSendPayment();

    }

    public void selectFromAccount(String accountNo) {
        selectByVisibleText(driver,value_FromAccount,accountNo);
    }

    public void clickOnSendPayment() {
        waitForElemntTobeClickable(driver,sendPayment,10).click();
    }

    public String getPaymentSuccessMessage() {
        return waitForElementTobeVisible(driver,PaymentSuccessMessage,10).getText();
    }








}
