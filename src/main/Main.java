package main;

import views.MenuLogin;

public class Main {
    public static void main(String[] args) {
        MenuLogin menu = new MenuLogin();
        while (true) {
            menu.menuLogin();
        }
    }
}
