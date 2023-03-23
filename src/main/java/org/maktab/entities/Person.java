package org.maktab.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue
    int id;
    String name;
    String phoneNumber;
}
