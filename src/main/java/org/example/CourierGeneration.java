package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class CourierGeneration {
    public static Courier getRandom(){
        String login = RandomStringUtils.randomAlphabetic(10);
        String passsword = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, passsword, firstName);
    }
    public static Courier getRandomWithLogin(){
        String password =RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(null, password, firstName);
    }
    public static Courier getRandomWithoutPassword(){
        String login = RandomStringUtils.randomAlphabetic(10);
        String firstName = RandomStringUtils.randomAlphabetic(10);
        return new Courier(login, null, firstName);
    }
}
