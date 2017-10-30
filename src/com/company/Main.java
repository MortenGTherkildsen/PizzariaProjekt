package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
	// write your code here

        Scanner scanner = new Scanner(System.in);

        ListeMedPizzaer menu = new ListeMedPizzaer();


        //menu.skrivMenu();
        menu.laesListeFraFil();
        //menu.udskrivListe();
        //menu.udskrivPizza(10);


        System.out.println(menu.getLength() + " pizzaer i menuen");
        boolean visMenu = true;
        String menuValg;



        while(visMenu) {
            System.out.println("M - Vis menu\n" +
                    "N - Ny ordre\n" +
                    "S - Statistik\n" +
                    "R - Rediger menu\n" +
                    "I - indlæs menu");

            menuValg = scanner.next();

            //*******************************************
            //Redigér menu / Opret ny pizza
            if (menuValg.equalsIgnoreCase("r")) {
                boolean svar = true;

                while (svar) {
                    menu = menu.indtastPizzaIMenu(menu);

                    System.out.println("Indtast flere? (j/n) ");
                    if (scanner.next().equalsIgnoreCase("n")) {
                        svar = false;
                    }

                    System.out.println("Vil du gemme menuen i en fil?");
                    if(scanner.next().equalsIgnoreCase("j"))
                        menu.skrivMenu(menu);
                }
                menu.udskrivListe(menu);
            }
            //*******************************************
            // Indlæs menuen fra fil
            if (menuValg.equalsIgnoreCase("i")) {

                menu.laesListeFraFil();
            }

            //*******************************************
            //Ny ordrebestilling
            if (menuValg.equalsIgnoreCase("n")) {
                System.out.println("Hvad er kundens navn?");
                String kundeNavn = scanner.next();

                ListeMedPizzaer ordre = new ListeMedPizzaer();
                ordre.setKundeNavn(kundeNavn);

                //ordre.udskrivListe(ordre);
                boolean svar = true;

                while (svar == true) {
                    System.out.println("Hvilken pizza vil du bestille?");

                    Pizza tempPizza = menu.getPizza(scanner.nextInt());

                    ordre.insertInList(tempPizza);
                    //ordre.udskrivListe(ordre);
                    //System.out.println(ordre.getLength());

                    System.out.println("Total: " + ordre.udregnPris(ordre));
                    System.out.println("Vil du bestille flere? (j/n) ");
                    if (scanner.next().equalsIgnoreCase("n")) {
                        svar = false;
                    }
                }

                ordre.udskrivListe(ordre);
                ordre.skrivMenu(ordre);

                System.out.println("Det bliver " + ordre.udregnPris((ordre)) + " kr.");
            }

            //*******************************************
            //Vis menu
            if (menuValg.equalsIgnoreCase("v")) {
                menu.udskrivListe(menu);
            }

//            //*******************************************
//            //
//            if(menuValg.equalsIgnoreCase("o")){
//
//            }
//            System.out.println();
//            visMenu = true;
            //menuValg = scanner.next();
        }


        /*Vis igangværende ordrer "(1. Pizza nr. 5, 2, 3, ...)" - while ordreliste!=tom -> print næste ordre

        // Vælg fra menu:
        // N - Ny ordre (Scanner scanner = new scanner)->Ordre ordre = new Ordre(pizzanummer)
        //
         S - Se statistik

        */
    }


}
