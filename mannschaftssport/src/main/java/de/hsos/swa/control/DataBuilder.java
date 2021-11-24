package de.hsos.swa.control;

import java.util.ArrayList;

import de.hsos.swa.entity.Type;
import de.hsos.swa.entity.DTOs.Attribute;
import de.hsos.swa.entity.DTOs.Data;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.Relationship;
import de.hsos.swa.entity.DTOs.TeamDTO;

public class DataBuilder {
    public static Data buildTeamData(TeamDTO team) {
        Data result = new Data();
        // id setzen
        result.id = team.id;

        // Typ setzen
        result.type = Type.TEAM;

        // Attribute setzen
        if (team.name != null || team.category != null) {
            Attribute attr = new Attribute();

            if (team.name != null) {
                attr.name = team.name;
            }
            if (team.category != null) {
                attr.category = team.category;
            }
            result.attributes = attr;
        }

        // Links setzen
        return result;
    }

    public Data addRelationshipManager(Data data, TeamDTO team) {
        // Relationships setzen
        if (team.manager != null) {
            Relationship rel = new Relationship();
            if (team.manager != null) {
                rel.manager = buildPersonData(team.manager, Type.MANAGER);
            }

            data.relationship = rel;
        }
        return data;
    }

    public Data addRelationshipPlayer(Data data, TeamDTO team) {
        // Relationships setzen
        if (team.players != null) {
            Relationship rel = new Relationship();
            if (team.players != null) {
                rel.players = buildPersonsData(team.players, Type.PLAYER);
            }
            data.relationship = rel;
        }
        return data;
    }

    public static ArrayList<Data> buildPersonsData(ArrayList<PersonDTO> persons, Type type) {
        // TODO PlayersData setzen
        ArrayList<Data> personsData = new ArrayList<Data>();
        for (PersonDTO person : persons) {

            // Players: id und Type setzen
            Data personData = new Data(person.id, type);

            // Players: Attribute setzen (nicht korrekt hier?)
            Attribute personAttr = new Attribute();
            if (person.name != null) {
                personAttr.setName(person.name);
                personData.setAttributes(personAttr);
            }
            personsData.add(personData);
            // TODO: Player Links setzen
        }
        return personsData;
    }

    public static Data buildPersonData(PersonDTO person, Type type) {
        // Manager: ID und Type setzen
        Data personData = new Data(person.id, type);

        // Manager: Attribute setzen (nicht korrekt hier?)
        Attribute personAttr = new Attribute();
        if (person.name != null) {
            personAttr.setName(person.name);
            personData.setAttributes(personAttr);
        }
        // TODO: Manager Links setzen
        return personData;
    }

}
