package de.hsos.swa.control;

import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.entity.DTOs.DataObject;

public interface SearchTeam {
    public DataObject searchTeam(int id);

    public DataObject searchAllTeams();

    public DataObject searchTeam(String name);
}
