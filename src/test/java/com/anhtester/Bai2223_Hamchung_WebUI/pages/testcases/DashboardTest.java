package com.anhtester.Bai2223_Hamchung_WebUI.pages.testcases;

import com.anhtester.Bai2223_Hamchung_WebUI.pages.pages.DashboardPage;
import com.anhtester.Bai2223_Hamchung_WebUI.pages.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1)
    public void testCheckDashboardTotal(){
        loginPage = new LoginPage(driver);

        //loginPage.loginCRM();

        //dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
    }

}