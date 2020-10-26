package de.telran.person.dto;

import de.telran.person.model.Person;

public class PersonDto {

    public int id;
    public String firstName;
    public String lastName;
    public int age;

    public PersonDto() {

    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
    }
}
