package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

//Bruges til menu samt ordreliste

public class ListeMedPizzaer {

    Pizza head = null;
    Pizza tail = null;

    public Date getBestillingAfgivet() {
        return bestillingAfgivet;
    }

    Date bestillingAfgivet = new Date();
    Date bestillingAfsluttet;

    public String getKundeNavn() {
        return kundeNavn;
    }

    public void setKundeNavn(String kundeNavn) {
        this.kundeNavn = kundeNavn;
    }

    private String kundeNavn;

    private int length;
    public int getLength() {
        return length;
    }

    // Bruges til at lave menuen (enten fra ny eller ved at læse fra fil)

    public ListeMedPizzaer indtastPizzaIMenu(ListeMedPizzaer menu){

        Scanner scanner = new Scanner(System.in);

        String temp = "";

            System.out.println("(T) Tilføj pizza");
            if(scanner.next().equalsIgnoreCase("t")){
                System.out.println("Hvad er pizzaens nummer?");
                int pizzanummer = scanner.nextInt();
                System.out.println("Hvad koster pizzaen?");
                int pris = scanner.nextInt();
                System.out.println("Hvad er pizzaens navn?");
                String navn = scanner.next();
                System.out.println("Hvad er toppings på " + navn + "?");
                String pizzatoppings = scanner.nextLine();

                Pizza pizza = new Pizza(pizzanummer, pris, navn, pizzatoppings);
                menu.insertInList(pizza);

        }
        return menu;
    }


    public void laesListeFraFil() throws FileNotFoundException{


        
        Scanner scanner = new Scanner(new File("menu.txt"));

        int menuNummer;
        int pris;
        String pizzaNavn;
        String pizzaToppings;

        this.setKundeNavn("Menu");
        while (scanner.hasNext()){
            menuNummer = scanner.nextInt();
            pris = scanner.nextInt();
            pizzaNavn = scanner.next();
            pizzaToppings = scanner.nextLine();

            Pizza pizza = new Pizza(menuNummer, pris, pizzaNavn, pizzaToppings);
            udskrivPizza(pizza);
            this.insertInList(pizza);
        }
    }

    public void skrivMenu() throws FileNotFoundException{
        PrintStream printStream = new PrintStream("menu.txt");

        String menukort = "1 57 Vesuvio: tomatsause, ost, skinke, oregano\n" +
                "2 53 Amerikaner: tomatsause, ost, oksefars og oregano\n" +
                "3 57 Cacciatore: tomatsauce, ost, pepperoni og oregano\n" +
                "4 63 Carbona: tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano\n" +
                "5 65 Dennis: tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano\n" +
                "6 57 Bertil: tomatsauce, ost, bacon og oregano\n" +
                "7 61 Silvia: tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano\n" +
                "8 61 Victoria: Tomatsauce, ost, skinke, ananas, champignon, løg og oregano\n" +
                "9 61 Toronfo: tomatsauce, ost, skinke, bacon, kebab, chili og oregano\n" +
                "10 61 Capricciosa: tomatsauce, ost, skinke, champignon og oregano\n" +
                "11 61 Hawai: tomatsauce, ost, skinke, ananas, oregano\n" +
                "12 61 Le Blissola: tomatsauce, ost, skinke, rejer og oregano\n" +
                "13 61 Venezia: tomatsauce, ost, skinke, bacon og oregano\n" +
                "14 61 Mafia: tomatsauce, ost, pepperoni, baocn, løg og oregano\n";

        printStream.println(menukort);

    }
    public void skrivMenu(ListeMedPizzaer menu) throws FileNotFoundException{
        PrintStream printStream = new PrintStream("menu2.txt");
        String temp = "";
        Pizza pizza;

        if(menu.getKundeNavn().equalsIgnoreCase("menu")){
            printStream.println("Menu\n");
        }
        else
        {
            printStream.println("Bestilling for " + menu.getKundeNavn() + " afgivet " + menu.getBestillingAfgivet());
        }

        for (int i = 0; i < length; i++) {
            pizza = menu.getPizza(i+1);

            temp =  pizza.getMenuNummer() + "\n" +
                    pizza.getPris() + "\n" +
                    pizza.getPizzaNavn() + "\n" +
                    pizza.getPizzaToppings() + "\n";

            printStream.println(temp);
        }
    }


    public void insertInList(Pizza pizza){

        if(this.head == null){
            this.head = pizza;
            this.tail = pizza;
            pizza.next = null;
        }
        else {
            this.tail.next = pizza;
            pizza.previous = this.tail;
            this.tail = pizza;
            pizza.next = null;
        }
        length++;
    }

    public int udregnPris(ListeMedPizzaer liste){
        int total = 0;
        for(Pizza pizza = liste.head; pizza != null; pizza = pizza.next) {
            total += pizza.getPris();
        }
        return total;
    }

    public void udskrivListe(ListeMedPizzaer tempListe){

        System.out.println(tempListe.getKundeNavn() + ":");
        for(Pizza pizza = tempListe.head; pizza != null; pizza = pizza.next) {
            udskrivPizza(pizza);
        }
        System.out.println(length + " pizzaer i alt.");

    }
    public void udskrivPizza(int pizzanummer){
        Pizza pizza = this.head;

        for (int i = 1; i < pizzanummer; i++) {
            pizza = pizza.next;
        }
        if(pizza!=null  && pizzanummer==pizza.getMenuNummer())
            System.out.println(pizza.getMenuNummer() + " " + pizza.getPris() + " kr. " + pizza.getPizzaNavn() + " " + pizza.getPizzaToppings());
    }

    public void udskrivPizza(Pizza pizza){
        System.out.println(pizza.getMenuNummer() + " " + pizza.getPris() + " kr. " + pizza.getPizzaNavn() + " " + pizza.getPizzaToppings());
    }

    public Pizza getPizza(int pizzanummer){
        Pizza pizza = head;

        for (int i = 1; i < pizzanummer; i++) {
            pizza = pizza.next;
        }
        System.out.println("Henter pizza nr. " + pizza.getMenuNummer() + " fra menuen i getPizza()...");
        return pizza;
    }



}
