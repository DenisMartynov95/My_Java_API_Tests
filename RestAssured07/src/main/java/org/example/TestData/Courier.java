package org.example.TestData;

import org.apache.commons.lang3.RandomStringUtils;

public class Courier {

    public final String login;
    public final String password;
    public final String firstName;

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public static Courier getRandomInfo(){ // Так как в тесте можно использовать рандомные данные для создания курьера, создаю метод для рандомизации данных каждого поля
        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, password, firstName); // и возвращаю в итоге созданные рандомные поля
    }

}