package org.maktab.services;

import org.maktab.entities.Person;
import org.maktab.repositories.PersonRepository;

public class PersonService {
    PersonRepository personRepository = new PersonRepository();
    public void create(Person person){
        personRepository.create(person);
    }
}
