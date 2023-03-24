package org.maktab.utils;

import org.maktab.entities.Person;
import org.maktab.services.PersonService;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class PersonUtils {
    Scanner scanner = new Scanner(System.in);
    PersonService personService = new PersonService();
    public Person fillingAPersonObject(){

        Person person = new Person();

        System.out.print("\nPlease enter the contact name : ");
        person.setName(scanner.nextLine());
        System.out.print("Please enter the contact number : ");
        person.setPhoneNumber(scanner.nextLine());

        return person;
    }

    public void findPersonByName(){
        System.out.print("\nPlease enter contact name : ");
        String name = scanner.nextLine();

        List<Person> personList = personService.find();
        AtomicReference<Person> atomicPerson = new AtomicReference<>();

        personList.forEach(x -> {
            if (x.getName().equals(name)){
                atomicPerson.set(x);
            }
        });

        if (atomicPerson.getOpaque() == null){
            System.out.println("\nThe entered name, does not exist!");
        } else {
            System.out.println("\nname : " + atomicPerson.getOpaque().getName() +
                    "\nphone number : " + atomicPerson.getOpaque().getPhoneNumber());
        }
    }
}
