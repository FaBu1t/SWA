package de.hsos.swa.control;

import java.util.ArrayList;

import javax.inject.Inject;

import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.Attribute;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.Relationship;
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
        Data result = new Data();
        if (repository.getTeam(id).isPresent()) {

            // id setzen
            TeamDTO team = repository.getTeam(id).get();
            result.setId(team.id);

            // Typ setzen
            result.setType(Type.TEAM);

            // Attribute setzen
            if (team.name != null || team.category != null) {
                Attribute attr = new Attribute();

                if (team.name != null) {
                    attr.setName(team.name);
                }
                if (team.category != null) {
                    attr.setCategory(team.category);
                }
                result.setAttributes(attr);
            }

            // Relationships setzen
            if (team.manager != null || team.players != null) {
                Relationship rel = new Relationship();
                if (team.manager != null) {

                    // Manager: ID und Type setzen
                    Data managerData = new Data(team.manager.id, Type.PERSON);

                    // Manager: Attribute setzen (nicht korrekt hier?)
                    Attribute managerAttr = new Attribute();
                    if (team.manager.name != null) {
                        managerAttr.setName(team.manager.name);
                        managerData.setAttributes(managerAttr);
                    }

                    // TODO: Manager Links setzen

                    rel.setManager(managerData);
                }
                if (team.players != null) {

                    // TODO PlayersData setzen
                    ArrayList<Data> PlayersData = new ArrayList<Data>();
                    for (PersonDTO player : team.players) {

                        // Players: id und Type setzen
                        Data playerData = new Data(player.id, Type.PERSON);

                        // Players: Attribute setzen (nicht korrekt hier?)
                        Attribute PlayerAttr = new Attribute();
                        if (player.name != null) {
                            PlayerAttr.setName(player.name);
                            playerData.setAttributes(PlayerAttr);
                        }

                        // TODO: Player Links setzen

                        PlayersData.add(playerData);
                    }
                    rel.setPlayers(PlayersData);
                }
                result.setRelationship(rel);
            }
            // TODO Links setzen
        }
        // TODO Send Error
        return result;
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
