package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {
    }

    public AuthInfo getValidAuthInfo() {
        return new AuthInfo("1111222233334444", 12, 24, "Vasya Vasin", 123);
    }

    private static String getRandomCardNumber() {return faker.finance().creditCard();
    }
    private static String getRandomLogin() {
        return faker.name().username();
    }

    private static String getRandomPassword() {
        return faker.internet().password();
    }

//    public static AuthInfo getRandomAuthInfo() {
//        return new AuthInfo(getRandomCardNumber(), 12, 24, getRandomLogin(), 123);
//    }


    @Value
    public class AuthInfo {
        String cardNumber;
        int mounth;
        int year;
        String name;
        int cvc;
    }
}
