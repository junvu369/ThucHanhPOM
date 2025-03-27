package com.anhtester.Bai2223_Hamchung_WebUI.pages.testcases;

import com.anhtester.Bai2223_Hamchung_WebUI.pages.pages.CustomerPage;
import com.anhtester.Bai2223_Hamchung_WebUI.pages.pages.DashboardPage;
import com.anhtester.Bai2223_Hamchung_WebUI.pages.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        String customerName = "Anh Tester 02122024AN1";

        customerPage.verifyNavigateToCustomerPage();
        int beforeTotal = customerPage.getCustomerTotal();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(customerName);
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(customerName);

        customerPage.clickMenuCustomer();
        int afterTotal = customerPage.getCustomerTotal();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "The total customer before and after add new not match.");
    }

    @Test
    public void testAddNewCustomer_SearchInTable() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        String customerName = "Anh Tester 02122024AN3";

        customerPage.verifyNavigateToCustomerPage();
        int beforeTotal = customerPage.getCustomerTotal();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(customerName);

        //Search and check customer name in table
        customerPage.searchAndCheckCustomerInTable(customerName);
        customerPage.clickFirstCustomer();

        //Verify data of new customer in profile page
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(customerName);

        //Compare total customer
        customerPage.clickMenuCustomer();
        int afterTotal = customerPage.getCustomerTotal();
        Assert.assertEquals(afterTotal, beforeTotal + 1, "The total customer before and after add new not match.");
    }

}
