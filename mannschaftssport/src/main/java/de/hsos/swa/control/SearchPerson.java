package de.hsos.swa.control;

import java.util.ArrayList;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;

public interface SearchPerson {
    public Data searchPerson(int id);
    public ArrayList<Data> searchPerson(String name);
}
