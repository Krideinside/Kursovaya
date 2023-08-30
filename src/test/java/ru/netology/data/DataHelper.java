package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String cardNumber;
        String month;
        String year;
        String name;
        String cvc;
    }

    public static AuthInfo getApproveAuthInfo() {
        return new AuthInfo("1111222233334444", generateMonth(randomShift()), generateYear(1), getRandomName(), getRandomCVC());
    }

    public static AuthInfo getDeclineAuthInfo() {
        return new AuthInfo("5555666677778888", generateMonth(randomShift()), generateYear(1), getRandomName(), getRandomCVC());
    }

    public static AuthInfo getRandomAuthInfo() {
        return new AuthInfo(getRandomCardNumber(), generateMonth(randomShift()), generateYear(1), getRandomName(), getRandomCVC());
    }

    public static int randomShift() {
        return Integer.parseInt(faker.numerify("#"));
    }

    public static String getRandomCardNumber() {
        return faker.finance().creditCard();
    }

    public static String generateMonth(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int shift) {
        return LocalDate.now().plusYears(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String getRandomName() {
        return faker.name().username();
    }

    public static String getRandomCVC() {
        return faker.numerify("###");
    }
}