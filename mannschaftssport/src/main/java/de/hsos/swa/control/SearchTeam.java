package de.hsos.swa.control;

import java.util.ArrayList;

import de.hsos.swa.entity.DTOs.Data;

public interface SearchTeam {
    public Data searchTeam(int id);
    public ArrayList<Data> searchTeam(String name);
}
