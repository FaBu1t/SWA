package de.hsos.swa.entity;

import java.util.ArrayList;

public class Team {
    private int id;
    private String name;
    private ArrayList<Person> player;
    private Person manager;
    public int getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }
    
    public ArrayList<Person> getPlayer() {
        return player;
    }
    
    public Person getManager() {
        return manager;
    }

    public Team(int id, String name, ArrayList<Person> player, Person manager) {
        this.id = id;
        this.name = name;
        this.player = player;
        this.manager = manager;
    }
   
    
}
