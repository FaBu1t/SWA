package de.hsos.swa.control;

import java.util.ArrayList;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.DataObject;

public interface SearchPerson {
    public DataObject searchPerson(int id);

    public DataObject searchPerson(String name);
}
