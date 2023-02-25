package org.example;

public class Courier {
    private String login;
    private String password;
    private String firstName;
    public Courier(String login, String passsword, String firstName){
        this.login =login;
        this.password = password;
        this.firstName = firstName;
    }
    public Courier(){};

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
