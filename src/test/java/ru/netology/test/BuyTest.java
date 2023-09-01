package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.pages.BuyPage;
import static com.codeborne.selenide.Selenide.open;

public class BuyTest {

    @BeforeAll
    static void setUpAll() { SelenideLogger.addListener("allure", new AllureSelenide()); }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @AfterAll
    static void tearDownAll() { SelenideLogger.removeListener("allure"); }

    /////////////////////////// POSITIVE BUY ///////////////////////////////

    @Test
    void shouldApproveBuy() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getApproveAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineBuy() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getDeclineAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldApproveCreditBuy() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeCreditBuy();
        var authUser = DataHelper.getApproveAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldDeclineCreditBuy() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeCreditBuy();
        var authUser = DataHelper.getDeclineAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    @Test
    void shouldRandomBuy() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        var authUser = DataHelper.getRandomAuthInfo();
        buyPage.fillForm(authUser);
        buyPage.successNotification();
    }

    ///////////////////////////  NEGATIVE SIMPLE BUY ///////////////////////////////

    @Test
    void testNegativeCard() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("1234123412341234");
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyCard() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(" ");
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyMonth() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyYear() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testEmptyName() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifEmptyField();
    }

    @Test
    void testEmptyCVC() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testShortCard() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber("12313");
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testExcessMonth() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth("13");
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorDate();
    }

    @Test
    void testExcessYear() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear("28");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorDate();
    }

    @Test
    void testZeroMonth() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth("0");
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testZeroYear() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear("0");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testPastYear() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear("22");
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifExpiredDate();
    }

    @Test
    void testKirName() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName("фыв");
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testShortName() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName("v");
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testNumberName() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName("123");
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testSymbolName() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(".*/");
        buyPage.setCVC(DataHelper.getRandomCVC());
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }

    @Test
    void testZeroCVC() {
        BuyPage buyPage = new BuyPage();
        buyPage.changeSimpleBuy();
        buyPage.setCardNumber(DataHelper.getApprovedCardNumber());
        buyPage.setMonth(DataHelper.generateMonth(1));
        buyPage.setYear(DataHelper.generateYear(1));
        buyPage.setName(DataHelper.getRandomName());
        buyPage.setCVC("0");
        buyPage.pushContinue();
        buyPage.notifErrorFormat();
    }
}