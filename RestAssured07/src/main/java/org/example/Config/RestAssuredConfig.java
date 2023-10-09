package org.example.Config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {

    public static RequestSpecification getBaseSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://qa-scooter.praktikum-services.ru/")
                .setContentType(ContentType.JSON)
                .build();
    }
}
