package org.example;

public class CourierAuthorization {
    public String login;
    public String password;
    public CourierAuthorization(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierAuthorization(String password) {
    }

    public CourierAuthorization from(Courier courier){
        return new CourierAuthorization(courier.getLogin(), courier.getPassword());

    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}