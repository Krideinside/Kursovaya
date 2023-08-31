package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pages.BuyPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.SQLHelper.cleanDatabase;


public class BuyTest {

    ///////////////////////////  POSITIVE  ///////////////////////////////

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

    ///////////////////////////  NEGATIVE SIMPLE BUY ///////////////////////////////

    @Test
    void shouldRandomBuy() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getRandomAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.errorNotification();
    }

    @Test
    void testNegativeCard() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1234123412341234");
        buyPage.setMonth("12");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyCard() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setMonth("12");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyMonth() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyYear() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("12");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyName() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("12");
        buyPage.setYear("24");
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyCVC() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("12");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testShortCard() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("12313");
        buyPage.setMonth("12");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testExcessMonth() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("13");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorDate();
    }

    @Test
    void testExcessYear() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("12");
        buyPage.setYear("28");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorDate();
    }

    @Test
    void testZeroMonth() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("0");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testZeroYear() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("0");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testPastYear() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("22");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifExpiredDate();
    }

    @Test
    void testKirName() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("24");
        buyPage.setName("фыв");
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testShortName() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("24");
        buyPage.setName("v");
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testNumberName() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("24");
        buyPage.setName("123");
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testSymbolName() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("24");
        buyPage.setName(".*/");
        buyPage.setCVC("123");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testZeroCVC() {
        open("http://localhost:8080");
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1111222233334444");
        buyPage.setMonth("10");
        buyPage.setYear("24");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("0");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }
}