package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;

public class TeamDTO {
    public int id;
    public String name;
    public ArrayList<PersonDTO> players;
    public PersonDTO manager;
    public String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TeamDTO() {
    }

    public TeamDTO(int id, String name, ArrayList<PersonDTO> player, PersonDTO manager, String category) {
        this.id = id;
        this.name = name;
        this.players = player;
        this.manager = manager;
        this.category = category;
    }

}
