package com.axelerant.scripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.axelerant.Listeners.TestListener;
import com.axelerant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegressionTest extends TestHelper {
    Login login;
    Homepage homepage;
    OpenNewAccount openNewAccount;
    AccountDetails accountDetails;
    BillPayment billPayment;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 0, description = "verifyCheckingAccountCanBeOpened")
    public void verifyCheckingAccountCanBeOpened() throws InterruptedException {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("PI 5.1");
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        extentTest.get().log(Status.PASS, "NewAccountOpen option is selected");
        openNewAccount.openCheckingAccount();
        extentTest.get().log(Status.PASS, "opened checking account");
        Assert.assertTrue(openNewAccount.isAccountOpened());
    }

    @Test(priority = 1, description = "verifySavingsAccountCanBeOpened")
    public void verifySavingsAccountCanBeOpened() throws InterruptedException {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("PI 5.1");
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        openNewAccount.openSavingsAccount();
        extentTest.get().log(Status.PASS, "opened savings account");
        Assert.assertTrue(openNewAccount.isAccountOpened());
    }

   @Test(priority = 1, description = "verifySavingsAccountDetails")
    public void verifySavingsAccountDetails() throws InterruptedException {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("PI 5.1");
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        String accountNumber= openNewAccount.openSavingsAccount();
        extentTest.get().log(Status.PASS, "Opened Savings Account");
        accountDetails = openNewAccount.clickOnAccount();
        Assert.assertEquals(accountDetails.getText_value_AccountNumber(),accountNumber);
        Assert.assertEquals(accountDetails.getText_value_AccountType(),"SAVINGS");
        Assert.assertEquals(accountDetails.getText_value_Balance(),"$100.00");
        Assert.assertEquals(accountDetails.getText_value_availableBalance(),"$100.00");

    }

    @Test(priority = 1, description = "verifyCheckingAccountDetails")
    public void verifyCheckingAccountDetails() throws InterruptedException {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("PI 5.1");
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        String accountNumber= openNewAccount.openCheckingAccount();
        extentTest.get().log(Status.PASS, "Opened Checking Account");
        accountDetails = openNewAccount.clickOnAccount();
        Assert.assertEquals(accountDetails.getText_value_AccountNumber(),accountNumber);
        Assert.assertEquals(accountDetails.getText_value_AccountType(),"CHECKING");
        Assert.assertEquals(accountDetails.getText_value_Balance(),"$100.00");
        Assert.assertEquals(accountDetails.getText_value_availableBalance(),"$100.00");
    }

    @Test(priority = 1, description = "verifyBillPaySavingsAccountDetails")
    public void verifyBillPaySavingsAccountDetails() throws InterruptedException {
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        String accountNumber= openNewAccount.openSavingsAccount();
        extentTest.get().log(Status.PASS, "savings account opened");
        accountDetails = openNewAccount.clickOnAccount();
        billPayment = homepage.clickOnBillPay();
        billPayment.EnterBillPaymentDetails("MIDHUN","5 Polaris Way","Aliso Viejo","California","92656","+919447729060","12456","12456","200",accountNumber);
        Assert.assertTrue(billPayment.getPaymentSuccessMessage().contains(accountNumber)&&billPayment.getPaymentSuccessMessage().contains("successful"));
    }

    @Test(priority = 1, description = "verifyBillPayCheckingAccountDetails")
    public void verifyBillPayCheckingAccountDetails() throws InterruptedException {
        login = new Login(driver);
        homepage = login.login("john", "demo");
        extentTest.get().log(Status.PASS, "Login is passed");
        openNewAccount =homepage.clickOnOpenNewAccount();
        String accountNumber= openNewAccount.openCheckingAccount();
        extentTest.get().log(Status.PASS, "checking account opened");
        accountDetails = openNewAccount.clickOnAccount();
        billPayment = homepage.clickOnBillPay();
        billPayment.EnterBillPaymentDetails("MIDHUN","5 Polaris Way","Aliso Viejo","California","92656","+919447729060","12456","12456","200",accountNumber);
        Assert.assertTrue(billPayment.getPaymentSuccessMessage().contains(accountNumber)&&billPayment.getPaymentSuccessMessage().contains("successful"));
    }

}
