package com.company;

import java.util.Date;

public class Pizza {

    Pizza previous = null;
    Pizza next = null;

    private int menuNummer;
    private String pizzaNavn;

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    private String pizzaToppings;
    private int pris;

    private String extra = "";
    private int prisForExtra = 0;



    public Pizza(int menuNummer, int pris, String pizzaNavn, String pizzaToppings) {
        this.menuNummer = menuNummer;
        this.pris = pris;
        this.pizzaNavn = pizzaNavn;
        this.pizzaToppings = pizzaToppings;
    }

    public int getMenuNummer() {
        return menuNummer;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public int getPris() {
        return pris;
    }

    public String getExtra() {
        return extra;
    }

}
