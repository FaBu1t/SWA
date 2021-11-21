package de.hsos.swa.control;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.TeamDTO;

public interface ChangeTeam {
    public Data changePerson(TeamDTO newTeam);
}
