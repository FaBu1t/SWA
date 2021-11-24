package de.hsos.swa.entity.DTOs;

public class PersonDTO {
    public int id;
    public String name;

    @Override
    public String toString() {
        return "PersonDTO [id=" + id + ", name=" + name + "]";
    }

    public PersonDTO() {
    };

    public PersonDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
