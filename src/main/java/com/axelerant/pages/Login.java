package com.axelerant.pages;



import com.axelerant.utilities.PageUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login extends PageUtility {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"loginPanel\"]//input[@value='Log In']")
    WebElement btn_Login;


    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Homepage login(String uName, String pWd) {
        userName.sendKeys(uName);
        password.sendKeys(pWd);
        btn_Login.click();
        return new Homepage(driver);
    }

}
