package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pages.BuyPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;


public class BuyTest {

    @Test
    void shouldValidBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.validBuy();
        buyPage.successNotification();
    }

    @Test
    void shouldValidBuy2() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        var authUser = DataHelper.getValidAuthInfo();
        buyPage.validBuy2(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineBuy2() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        var authUser = DataHelper.getDeclineAuthInfo();
        buyPage.validBuy2(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldValidCreditBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.validCreditBuy();
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.declineBuy();
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineCreditBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.declineCreditBuy();
        buyPage.successNotification();
    }
}