package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;

public class TeamDTO {
    public int id;
    public String name;
    public ArrayList<PersonDTO> player;
    public PersonDTO manager;

    public TeamDTO(int id, String name, ArrayList<PersonDTO> player, PersonDTO manager) {
        this.id = id;
        this.name = name;
        this.player = player;
        this.manager = manager;
    }

}
