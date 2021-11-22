package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;

public class Relationship {
    private Data manager;
    private ArrayList<Data> players;
    
    public Data getManager() {
        return manager;
    }
    public void setManager(Data manager) {
        this.manager = manager;
    }
    public ArrayList<Data> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Data> players) {
        this.players = players;
    }
    
   
    

}