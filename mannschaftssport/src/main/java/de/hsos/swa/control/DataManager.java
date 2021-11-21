package de.hsos.swa.control;

import java.util.ArrayList;

import javax.inject.Inject;

import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
import de.hsos.swa.gateway.MockRepository;

public class DataManager implements SearchPerson, CreatePerson, ChangePerson, DeletePerson, SearchTeam, CreateTeam, ChangeTeam, DeleteTeam  {
    
    @Inject MockRepository repository;

    @Override
    public Data deleteTeam(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data changePerson(TeamDTO newTeam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data createTeam(TeamDTO newTeam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data searchTeam(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Data> searchTeam(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data deletePerson(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data changePerson(PersonDTO newPerson) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data createPerson(PersonDTO newPerson) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Data searchPerson(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Data> searchPerson(String name) {
        // TODO Auto-generated method stub
        return null;
    }
}
