package de.hsos.swa.control;

import de.hsos.swa.entity.DTOs.DataObject;
import de.hsos.swa.entity.DTOs.TeamDTO;

public interface CreateTeam {
    public DataObject createTeam(TeamDTO newTeam);

}
