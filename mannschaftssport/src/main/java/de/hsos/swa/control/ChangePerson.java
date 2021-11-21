package de.hsos.swa.control;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;

public interface ChangePerson {
    public Data changePerson(PersonDTO newPerson);
    
}
