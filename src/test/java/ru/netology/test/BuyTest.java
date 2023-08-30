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
    void shouldApproveBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getApproveAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getDeclineAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldApproveCreditBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeCreditBuy();
        var authUser = DataHelper.getApproveAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineCreditBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeCreditBuy();
        var authUser = DataHelper.getDeclineAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldRandomBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getRandomAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.errorNotification();
    }
}