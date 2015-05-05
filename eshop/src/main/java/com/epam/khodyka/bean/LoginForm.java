package com.epam.khodyka.bean;

/**
 * Created by Andrii_Khodyka on 4/30/2015.
 */
public class LoginForm {

    private Input login;
    private Input password;

    public LoginForm() {
        this.login = new StringInput();
        this.password = new StringInput();
    }

    public Input getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login.setValue(login);
    }

    public Input getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }
}
