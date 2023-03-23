package org.maktab.utils;

import org.maktab.entities.Person;
import java.util.Scanner;

public class PersonUtils {
    Scanner scanner = new Scanner(System.in);
    public Person fillingAPersonObject(){

        Person person = new Person();

        System.out.print("\nPlease enter the contact name : ");
        person.setName(scanner.nextLine());
        System.out.print("\nPlease enter the contact number : ");
        person.setPhoneNumber(scanner.nextLine());

        return person;
    }
}
