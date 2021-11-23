package de.hsos.swa.control;

import java.util.ArrayList;
import java.util.Optional;

import javax.inject.Inject;

import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
import de.hsos.swa.gateway.MockRepository;

public class DataManager implements SearchPerson, CreatePerson, ChangePerson, DeletePerson, SearchTeam, CreateTeam,
        ChangeTeam, DeleteTeam {

    @Inject
    MockRepository repository;

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
        Optional<TeamDTO> opt = repository.getTeam(id);
        if (opt.isPresent()) {
            return DataBuilder.buildTeamData(opt.get());
        }
        // TODO Send Error
        return null;
    }

    @Override
    public ArrayList<Data> searchTeam(String name) {
        Optional<ArrayList<TeamDTO>> opt = repository.getTeam(name);
        ArrayList<Data> result = new ArrayList<Data>();
        if (opt.isPresent()) {
            for (TeamDTO team : opt.get()) {
                result.add(DataBuilder.buildTeamData(team));
            }
        }
        // TODO Send Error
        return null;
    }

    @Override
    public ArrayList<Data> searchAllTeams() {
        Optional<ArrayList<TeamDTO>> opt = repository.getAllTeam();
        ArrayList<Data> result = new ArrayList<Data>();
        if (opt.isPresent()) {
            for (TeamDTO team : opt.get()) {
                result.add(DataBuilder.buildTeamData(team));
            }
        }
        // TODO Send Error
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
        Optional<PersonDTO> opt = repository.getPerson(id);
        if (opt.isPresent()) {
            return DataBuilder.buildPersonData(opt.get(), Type.PERSON);
        }
        return null;
    }

    @Override
    public ArrayList<Data> searchPerson(String name) {
        Optional<ArrayList<PersonDTO>> opt = repository.getPerson(name);
        if (opt.isPresent()) {
            return DataBuilder.buildPersonsData(opt.get(), Type.PERSON);
        }
        return null;
    }

}
