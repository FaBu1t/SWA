package de.hsos.swa.control;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.AssertTrue.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriInfo;

import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.DataObject;
import de.hsos.swa.entity.DTOs.Error;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
import de.hsos.swa.gateway.MockRepository;
import de.hsos.swa.shared.UriBuilder;

@ApplicationScoped
public class DataManager implements SearchPerson, CreatePerson, ChangePerson, DeletePerson, SearchTeam, CreateTeam,
        ChangeTeam, DeleteTeam {

    @Inject
    MockRepository repository;

    @Context
    UriInfo uriInfo;

    @Override
    public boolean deleteTeam(int id) {
        return repository.deleteTeam(id);
    }

    @Override
    public DataObject changePerson(TeamDTO newTeam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean createTeam(TeamDTO newTeam) {

        return repository.changeTeam(newTeam);

    }

    @Override
    public DataObject searchTeam(int id) {
        DataObject resultDataObject = new DataObject();
        Optional<TeamDTO> opt = repository.getTeam(id);

        if (opt.isPresent()) {

            System.out.println("ID: " + id);

            resultDataObject.data.add(DataBuilder.buildTeamData(opt.get()));
            return resultDataObject;
        }
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

    @Override
    public DataObject searchTeam(String name) {
        Optional<ArrayList<TeamDTO>> opt = repository.getTeam(name);
        DataObject resultDataObject = new DataObject();
        if (opt.isPresent()) {
            for (TeamDTO team : opt.get()) {

                resultDataObject.data.add((DataBuilder.buildTeamData(team)));
            }
            return resultDataObject;
        }
        // TODO Send Error
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

    @Override
    public DataObject searchAllTeams() {

        DataObject resultDataObject = new DataObject();
        Optional<ArrayList<TeamDTO>> opt = repository.getAllTeam();
        if (opt.isPresent()) {
            for (TeamDTO team : opt.get()) {

                resultDataObject.data.add(DataBuilder.buildTeamData(team));
            }
            return resultDataObject;
        }
        // TODO Send Error
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

    public DataObject searchTeamByCategory(String category) {
        Optional<ArrayList<TeamDTO>> opt = repository.getTeamByCategory(category);
        DataObject resultDataObject = new DataObject();
        if (opt.isPresent()) {
            for (TeamDTO team : opt.get()) {
                resultDataObject.data.add((DataBuilder.buildTeamData(team)));
            }
            return resultDataObject;
        }
        // TODO Send Error
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

    @Override
    public boolean deletePerson(int id) {
        return repository.deletePerson(id);
    }

    @Override
    public DataObject changePerson(PersonDTO newPerson) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean createPerson(PersonDTO newPerson) {
        return repository.createPerson(newPerson);
    }

    @Override
    public DataObject searchPerson(int id) {
        DataObject resultDataObject = new DataObject();
        Optional<PersonDTO> opt = repository.getPerson(id);
        if (opt.isPresent()) {
            resultDataObject.data.add(DataBuilder.buildPersonData(opt.get(), Type.PERSON));
            return resultDataObject;
        }
        // TODO Send Error
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

    @Override
    public DataObject searchPerson(String name) {
        DataObject resultDataObject = new DataObject();
        Optional<ArrayList<PersonDTO>> opt = repository.getPerson(name);
        if (opt.isPresent()) {
            resultDataObject.data.addAll(DataBuilder.buildPersonsData(opt.get(), Type.PERSON));
            return resultDataObject;
        }
        // TODO Send Error
        resultDataObject.error = new Error("ERRORRRR");
        return resultDataObject;
    }

}
