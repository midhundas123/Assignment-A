package com.axelerant.scripts;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import com.aventstack.extentreports.ExtentTest;

import com.axelerant.Listeners.TestListener;
import com.axelerant.pages.*;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;

import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;


public class Applitools extends TestHelper {

    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    VisualGridRunner runner = new VisualGridRunner(1);

    Eyes eyes = new Eyes(runner);

    @Test (priority = 1, description = "verifyBillPayCheckingAccountDetails")
    public void visualTestingExample() throws InterruptedException {
        setUp(eyes);
        try {
            ultraFastTest(driver, eyes);

        } finally {
            tearDown(driver, runner);
        }
    }

    private void tearDown(WebDriver driver, VisualGridRunner runner) {
        driver.quit();
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }

    public static void ultraFastTest(WebDriver webDriver, Eyes eyes) {

        try {
            Login login = new Login(webDriver);
            eyes.open(webDriver, "Demo App", "Ultrafast grid demo", new RectangleSize(800, 600));
            eyes.check(Target.window().fully().withName("Login page"));
            //webDriver.findElement(By.id("log-in")).click();
            login.login("john","demo");
            eyes.check(Target.window().fully().withName("App page"));
            eyes.closeAsync();
        } finally {
            eyes.abortAsync();
        }
    }

        public static void setUp (Eyes eyes){
            Configuration config = new Configuration();
            config.setApiKey("ryO100odB104LbZ6TeobyqTSuUQxBjwXBCXozR101OgjDzZhw110");
            config.setBatch(new BatchInfo("Ultrafast Batch"));
            config.addBrowser(800, 600, BrowserType.CHROME);
            config.addBrowser(700, 500, BrowserType.FIREFOX);
            config.addBrowser(1600, 1200, BrowserType.IE_11);
            config.addBrowser(1024, 768, BrowserType.EDGE_CHROMIUM);
            config.addBrowser(800, 600, BrowserType.SAFARI);
            config.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
            config.addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT);
            eyes.setConfiguration(config);
        }


    }


