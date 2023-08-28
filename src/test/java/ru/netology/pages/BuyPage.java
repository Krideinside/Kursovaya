package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BuyPage {
    public ElementsCollection buttons = $$("[type='button']");
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement mounthField = $("[wfd-id=id1]");
    private final SelenideElement yearField = $("[wfd-id=id2]");
    private final SelenideElement nameField = $("[wfd-id=id3]");
    private final SelenideElement cvcField = $("[wfd-id=id4]");
    private final SelenideElement continueButton = buttons.findBy(exactText("Продолжить"));
    private final SelenideElement sendToBank = buttons.findBy(exactText("Отправляем запрос в Банк"));
//    public ElementsCollection notificationTitle = $$("[class='notification__title']");
    private final SelenideElement success = $("[class='notification__title']").shouldHave(text("Успешно"));
//    public ElementsCollection notificationContent = $$("[class='notification__content']");
//    private final SelenideElement successNotif = notificationTitle.findBy(exactText("Успешно"));
//    private final SelenideElement successContent = notificationContent.findBy(exactText("Операция одобрена Банком."));

    public void validBuy() {
        buttons.findBy(Condition.exactText("Купить")).click();
//        cardNumberField.click();
        cardNumberField.setValue("1111222233334444");
//        mounthField.click();
        mounthField.setValue("12");
//        yearField.click();
        yearField.setValue("24");
//        nameField.click();
        nameField.setValue("Vasya Vasin");
//        cvcField.click();
        cvcField.setValue("123");
        continueButton.click();
//        continueButton.shouldBe(visible, Duration.ofSeconds(15));
        sendToBank.shouldBe(visible, Duration.ofSeconds(15));
        success.shouldBe(visible);
    }

    public void validCreditBuy() {
        buttons.findBy(Condition.exactText("Купить в кредит")).click();
        cardNumberField.click();
        cardNumberField.setValue("1111222233334444");
        mounthField.click();
        mounthField.setValue("12");
        yearField.click();
        yearField.setValue("24");
        nameField.click();
        nameField.setValue("Vasya Vasin");
        cvcField.click();
        cvcField.setValue("123");
        continueButton.click();
        continueButton.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void declineBuy() {
        buttons.findBy(Condition.exactText("Купить")).click();
        cardNumberField.click();
        cardNumberField.setValue("5555666677778888");
        mounthField.click();
        mounthField.setValue("12");
        yearField.click();
        yearField.setValue("24");
        nameField.click();
        nameField.setValue("Vasya Vasin");
        cvcField.click();
        cvcField.setValue("123");
        continueButton.click();
        continueButton.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void declineCreditBuy() {
        buttons.findBy(Condition.exactText("Купить в кредит")).click();
        cardNumberField.click();
        cardNumberField.setValue("5555666677778888");
        mounthField.click();
        mounthField.setValue("12");
        yearField.click();
        yearField.setValue("24");
        nameField.click();
        nameField.setValue("Vasya Vasin");
        cvcField.click();
        cvcField.setValue("123");
        continueButton.click();
        continueButton.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void declineCreditBuyClean() {
        buttons.findBy(Condition.exactText("Купить в кредит")).click();
        cardNumberField.click();
        cardNumberField.setValue("5555666677778888");
        mounthField.click();
        mounthField.setValue("12");
        yearField.click();
        yearField.setValue("24");
        nameField.click();
        nameField.setValue("Vasya Vasin");
        cvcField.click();
        cvcField.setValue("123");
clean();
    }

    public void clean() {
//        cardNumberField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        cardNumberField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        mounthField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        yearField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        nameField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        cvcField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        continueButton.shouldBe(visible, Duration.ofSeconds(15));
    }
}
