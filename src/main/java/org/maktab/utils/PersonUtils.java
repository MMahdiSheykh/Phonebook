package org.maktab.utils;

import org.maktab.entities.Person;
import org.maktab.services.PersonService;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class PersonUtils {
    Scanner scanner = new Scanner(System.in);
    PersonService personService = new PersonService();

    public Person fillingAPersonObject() {

        Person person = new Person();

        System.out.print("\nPlease enter the contact name : ");
        person.setName(scanner.nextLine());
        System.out.print("Please enter the contact number : ");
        person.setPhoneNumber(scanner.nextLine());

        return person;
    }

    public void findPersonByName() {
        System.out.print("\nPlease enter contact name : ");
        String name = scanner.nextLine();

        List<Person> personList = personService.find();
        AtomicReference<Person> atomicPerson = new AtomicReference<>();

        personList.forEach(x -> {
            if (x.getName().equals(name)) {
                atomicPerson.set(x);
            }
        });

        if (atomicPerson.getOpaque() == null) {
            System.out.println("\nThe entered name does not exist!");
        } else {
            System.out.println("\nname : " + atomicPerson.getOpaque().getName() +
                    "\nphone number : " + atomicPerson.getOpaque().getPhoneNumber());
        }
    }

    public void findPersonByNumber() {

        System.out.print("\nPlease enter contact number : ");
        String number = scanner.nextLine();

        List<Person> personList = personService.find();
        AtomicReference<Person> atomicPerson = new AtomicReference<>();

        personList.forEach(x -> {
            if (x.getPhoneNumber().equals(number)) {
                atomicPerson.set(x);
            }
        });

        if (atomicPerson.getOpaque() == null) {
            System.out.println("\nThe entered number does not exist!");
        } else {
            System.out.println("\nname : " + atomicPerson.getOpaque().getName() +
                    "\nphone number : " + atomicPerson.getOpaque().getPhoneNumber());
        }
    }

    public void deletePersonByName() {
        AtomicReference<Person> atomicPerson = new AtomicReference<>(new Person());

        System.out.print("\nPlease enter the name of contact you want to delete : ");
        String name = scanner.nextLine();

        List<Person> personList = personService.find();
        personList.forEach(x -> {
            if (x.getName().equals(name)) {
                atomicPerson.set(x);
            }
        });

        if (atomicPerson.getOpaque().getName() == null) {
            System.out.println("\nThe entered name does not exist!");
        } else {
            personService.delete(atomicPerson.getOpaque());
            System.out.println("\nYour contact has been successfully deleted");
        }
    }

    public void deletePersonByNumber(){
        AtomicReference<Person> atomicPerson = new AtomicReference<>(new Person());

        System.out.print("\nPlease enter the number of contact you want to delete : ");
        String number = scanner.nextLine();

        List<Person> personList = personService.find();
        personList.forEach(x -> {
            if (x.getPhoneNumber().equals(number)) {
                atomicPerson.set(x);
            }
        });

        if (atomicPerson.getOpaque().getPhoneNumber() == null) {
            System.out.println("\nThe entered number does not exist!");
        } else {
            personService.delete(atomicPerson.getOpaque());
            System.out.println("\nYour contact has been successfully deleted");
        }
    }
}
