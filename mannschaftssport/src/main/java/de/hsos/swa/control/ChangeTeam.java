package de.hsos.swa.control;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.TeamDTO;
import de.hsos.swa.entity.DTOs.DataObject;

public interface ChangeTeam {
    public DataObject changeTeam(TeamDTO newTeam);
}
