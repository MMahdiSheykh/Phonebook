package org.maktab;

import org.maktab.services.PersonService;
import org.maktab.utils.PersonUtils;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    PersonService personService = new PersonService();
    PersonUtils personUtils = new PersonUtils();

    public void panel() {
        System.out.print("\nWelcome to your phone book\n\n" +
                " 1.Save a new contact\n" +
                " 2.Find a contact by name\n" +
                " 3.Find a contact by number\n" +
                " 4.Delete a contact by name\n" +
                " 5.Delete a contact by number\n" +
                " 6.Exit\n\n" +
                "Please enter the number of the option you want : ");

        int chooser = scanner.nextInt();
        switch (chooser){
            case 1:
                personService.create();
                waitMenu();
                panel();
                break;
            case 2:
                personUtils.findPersonByName();
                waitMenu();
                panel();
                break;
            case 3:
                personUtils.findPersonByNumber();
                waitMenu();
                panel();
                break;
            case 4:
                personUtils.deletePersonByName();
                waitMenu();
                panel();
                break;
            case 5:
                personUtils.deletePersonByNumber();
                waitMenu();
                panel();
                break;
            case 6:
                break;

        }
    }

    public void waitMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress enter to continue...\n");
        scanner.nextLine();
    }
}
