package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;

public class TeamDTO {
    private int id;
    private String name;
    private ArrayList<PersonDTO> player;
    private PersonDTO manager;
   
    public TeamDTO(int id, String name, ArrayList<PersonDTO> player, PersonDTO manager) {
        this.id = id;
        this.name = name;
        this.player = player;
        this.manager = manager;
    }

    
}
