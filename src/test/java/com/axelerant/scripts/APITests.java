package com.axelerant.scripts;

import com.aventstack.extentreports.ExtentTest;
import com.axelerant.Listeners.TestListener;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class APITests {
    final static String ROOT_URI = "https://parabank.parasoft.com";
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 0, description = "APITests")
    public void API_test() {
        extentTest.get().assignCategory("APITests");

       //get session ID
        Response response = given()

                .and()
                .when()
                .get(ROOT_URI+"/parabank/index.htm")
                .then().statusCode(200)
                .extract().response();


        String JsessionID = response.getCookie("JSESSIONID");



        //Login

        Response response_login = given()
                .header("Content-type", "text/plain")
                .and()
                .param("username","john")
                .param("password","demo")
                .when()
                .post(ROOT_URI+"/parabank/login.htm;"+"jsessionid="+JsessionID)
                .then()
                .extract().response();

        //getcustomer ID

        //CreateAccount

        Response response_CreateAccount = given()
                .header("Content-type", "text/plain")
                .and()
                .when()
                .post(ROOT_URI+"/parabank/services_proxy/bank/createAccount?customerId=12212&newAccountType=0&fromAccountId=13344")
                .then()
                .extract().response();
        System.out.println(response_CreateAccount.statusCode());

        //Assertion TO DO ,Work is in progress

    }

}
