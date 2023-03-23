package org.maktab.services;

import org.maktab.entities.Person;
import org.maktab.repositories.PersonRepository;
import org.maktab.utils.PersonUtils;
import java.util.List;

public class PersonService {
    PersonRepository personRepository = new PersonRepository();
    PersonUtils personUtils = new PersonUtils();

    public void create(){
        personRepository.create(personUtils.fillingAPersonObject());
    }

    public List<Person> find(){
        return personRepository.find();
    }
}
