package org.maktab;

import org.maktab.services.PersonService;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    PersonService personService = new PersonService();

    public void welcomePanel() {
        System.out.print("\nWelcome to your phone book\n\n" +
                " 1.Save a new contact\n" +
                " 2.Find a contact by number\n" +
                " 3.Find a contact by name\n" +
                " 4.Delete a contact by number\n" +
                " 5.Delete a contact by name\n\n" +
                "Please enter the number of the option you want : ");

        int chooser = scanner.nextInt();
        switch (chooser){
            case 1:
                personService.create();
                System.out.println("\nCreating a new contact was done successfully...");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
}
