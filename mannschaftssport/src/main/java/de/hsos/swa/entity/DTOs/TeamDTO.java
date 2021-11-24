package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Link;

import javax.json.bind.annotation.JsonbProperty;

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

    public TeamDTO(int id, String name, ArrayList<PersonDTO> player, PersonDTO manager) {
        this.id = id;
        this.name = name;
        this.players = player;
        this.manager = manager;
    }

}
