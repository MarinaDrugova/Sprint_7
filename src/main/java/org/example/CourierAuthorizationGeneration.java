package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierAuthorizationGeneration {
    public static CourierAuthorization getRandom() {
        String login = RandomStringUtils.randomAlphabetic(10);
        String password = RandomStringUtils.randomAlphabetic(10);
        return new CourierAuthorization(login, password);
    }
}
