package de.hsos.swa.entity;

import de.hsos.swa.entity.DTOs.PersonDTO;

public class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static class Converter {

        public static PersonDTO toDTO(Person person) {
            return new PersonDTO(person.getId(), person.getName());

        }

        public static Person toPerson(PersonDTO person) {
            return new Person(person.id, person.name);
        }

    }

}
