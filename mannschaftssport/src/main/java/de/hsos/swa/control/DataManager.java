package de.hsos.swa.control;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.DataObject;
import de.hsos.swa.entity.DTOs.Error;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
import de.hsos.swa.gateway.MockRepository;

@ApplicationScoped
public class DataManager implements SearchPerson, CreatePerson, ChangePerson, DeletePerson, SearchTeam, CreateTeam,
        ChangeTeam, DeleteTeam {

    private AtomicInteger counter = new AtomicInteger(0);

    @Inject
    MockRepository repository;

    @Context
    UriInfo uriInfo;

    @Override
    public boolean deleteTeam(int id) {
        return repository.deleteTeam(id);
    }

    @Override
    public DataObject changeTeam(TeamDTO newTeam) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataObject createTeam(TeamDTO newTeam) {
        DataObject resultDataObject = new DataObject();
        newTeam.id = counter.incrementAndGet();
        Optional<TeamDTO> opt = repository.createTeam(newTeam);
        if (opt.isPresent()) {
            resultDataObject.data.add(DataBuilder.buildTeamData(opt.get(), null));
            return resultDataObject;
        }
        return null;

    }

    @Override
    public DataObject searchTeam(int id, String relType) {
        DataObject resultDataObject = new DataObject();
        Optional<TeamDTO> opt = repository.getTeam(id);
        if (opt.isPresent()) {
            System.out.println("ID: " + id);
            resultDataObject.data.add(DataBuilder.buildTeamData(opt.get(), relType));
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
                resultDataObject.data.add((DataBuilder.buildTeamData(team, null)));
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
                resultDataObject.data.add(DataBuilder.buildTeamData(team, null));
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
                resultDataObject.data.add((DataBuilder.buildTeamData(team, null)));
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

    public DataObject addManager(int id, PersonDTO manager) {
        Optional<TeamDTO> opt = repository.getTeam(id);
        if (opt.isPresent()) {
            opt.get().manager = manager;
            this.changeTeam(opt.get());
            DataObject resultDataObject = new DataObject();
            resultDataObject.data.add(DataBuilder.buildPersonData(opt.get().manager, null));
            return resultDataObject;
        }
        return null;
    }

}
