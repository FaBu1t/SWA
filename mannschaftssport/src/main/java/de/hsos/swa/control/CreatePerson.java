package de.hsos.swa.control;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.DataObject;

public interface CreatePerson {
    public boolean createPerson(PersonDTO newPerson);
}
