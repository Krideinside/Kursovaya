package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.pages.BuyPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;


public class BuyTest {

    @Test
    void shouldValidBuy() {
        open("http://localhost:8080");
        new BuyPage().validBuy();
    }

    @Test
    void shouldValidCreditBuy() {
        open("http://localhost:8080");
        new BuyPage().validCreditBuy();
    }

    @Test
    void shouldDeclineBuy() {
        open("http://localhost:8080");
        new BuyPage().declineBuy();
    }

    @Test
    void shouldDeclineCreditBuy() {
        open("http://localhost:8080");
        new BuyPage().declineCreditBuy();
    }

    @Test
    void shouldDeclineCreditBuyClean() {
        open("http://localhost:8080");
        new BuyPage().declineCreditBuyClean();
    }

//    @Test
//    void successBuy() {
//        open("http://localhost:8080");
//        LoginPage loginPage = new LoginPage();
//        loginPage.validBuy();
//    }


//    @Test
//    void randomUser() {
//        var loginPage = open("http://localhost:9999", LoginPage.class);
//        var authInfo = DataHelper.getRandomAuthInfo();
//        loginPage.validLogin(authInfo);
//        loginPage.verifyErrorVisibility();
//    }
//
//    @Test
//    void invalidLogin() {
//        var loginPage = open("http://localhost:9999", LoginPage.class);
//        var authUser = new DataHelper.AuthInfo(DataHelper.getRandomAuthInfo().getLogin(),
//                DataHelper.getAuthInfoWithTestData().getPassword());
//        loginPage.validLogin(authUser);
//        loginPage.verifyErrorVisibility();
//    }
//
//    @Test
//    void invalidPass() {
//        var loginPage = open("http://localhost:9999", LoginPage.class);
//        var authUser = new DataHelper.AuthInfo(DataHelper.getAuthInfoWithTestData().getLogin(),
//                DataHelper.getRandomAuthInfo().getPassword());
//        loginPage.validLogin(authUser);
//        loginPage.verifyErrorVisibility();
//    }
//
//    @Test
//    void invalidVerifyCode() {
//        var loginPage = open("http://localhost:9999", LoginPage.class);
//        var authUser = DataHelper.getAuthInfoWithTestData();
//        var verifyPage = loginPage.validLogin(authUser);
//        verifyPage.verifyPageVisibility();
//        var verifyCode = DataHelper.getRandomVerificationCode().getCode();
//        verifyPage.verify(verifyCode);
//        verifyPage.errorVisibility();
//    }
}