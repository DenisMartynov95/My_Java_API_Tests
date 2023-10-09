package org.example.TestData;

                    /*
                             Класс для логина

                                                  */
public class CourierInfo {
    public final String login;
    public final String password;

    public CourierInfo(String login, String password) {
        this.login = login;
        this.password = password;
    }


                        // Метод для изымания логина и пароля
    public static CourierInfo from(Courier courier) {
        return new CourierInfo(courier.login, courier.password);
                        }
                    }
