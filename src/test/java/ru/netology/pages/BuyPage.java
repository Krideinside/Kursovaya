package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;
import javax.activation.DataHandler;
import javax.management.Notification;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BuyPage {
    public ElementsCollection buttons = $$("[type='button']");
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[wfd-id=id1]");
    private final SelenideElement yearField = $("[wfd-id=id2]");
    private final SelenideElement nameField = $("[wfd-id=id3]");
    private final SelenideElement cvcField = $("[wfd-id=id4]");
    private final SelenideElement continueButton = buttons.findBy(exactText("Продолжить"));
    private final SelenideElement sendToBank = buttons.findBy(exactText("Отправляем запрос в Банк..."));
    private final SelenideElement notificationTitle = $("[class=notification__title]");
    private final SelenideElement notificationContent = $("[class=notification__content]");

    public ElementsCollection errorFill = $$("[class=input__inner]");

    public void changeSimpleBuy() {
        buttons.findBy(Condition.exactText("Купить")).click();
    }
    public void changeCreditBuy() {
        buttons.findBy(Condition.exactText("Купить в кредит")).click();
    }

    public void setCardNumber(String number) { cardNumberField.setValue(number); }
    public void setMonth(String month) { monthField.setValue(month); }
    public void setYear(String year) { yearField.setValue(year); }
    public void setName(String name) { nameField.setValue(name); }
    public void setCVC(String cvc) { cvcField.setValue(cvc); }

    public void pushContinue() { continueButton.click(); }

    public void notifErrorFormat() { errorFill.findBy(text("Неверный формат")); }
    public void notifErrorDate() { errorFill.findBy(text("Неверно указан срок действия карты")); }
    public void notifExpiredDate() { errorFill.findBy(text("Истёк срок действия карты")); }
    public void notifEmptyField() { errorFill.findBy(text("Поле обязательно для заполнения")); }

    public void fillForm(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        nameField.setValue(info.getName());
        cvcField.setValue(info.getCvc());
        continueButton.click();
        sendToBank.shouldBe(visible);
    }

    public void successNotification() {
        notificationTitle.shouldHave(exactText("Успешно"), Duration.ofSeconds(15));
        notificationContent.shouldHave(exactText("Операция одобрена Банком."));
    }

    public void errorNotification() {
        notificationTitle.shouldHave(exactText("Ошибка"));
        notificationContent.shouldHave(exactText("Ошибка! Банк отказал в проведении операции."));
    }
}
