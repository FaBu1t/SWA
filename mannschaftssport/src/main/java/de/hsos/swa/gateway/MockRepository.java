package de.hsos.swa.gateway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import de.hsos.swa.entity.Person;
import de.hsos.swa.entity.Team;
import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;

import java.util.Optional;

@ApplicationScoped
public class MockRepository {
    private Map<Integer, Person> persons = new HashMap<>();
    private Map<Integer, Team> teams = new HashMap<>();

    public Optional<PersonDTO> getPerson(int id) {
        return Optional.ofNullable(Person.Converter.toDTO(persons.get(id)));
    }

    public Optional<ArrayList<PersonDTO>> getPerson(String name) {
        ArrayList<PersonDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Person> entry : persons.entrySet()) {
            if (entry.getValue().getName() == name) {
                result.add(Person.Converter.toDTO(entry.getValue()));
            }
        }
        return Optional.ofNullable(result);
    }

    public Optional<TeamDTO> getTeam(int id) {
        // TODO
        return null;
    }

    public Optional<PersonDTO> deletePerson(int id) {
        // TODO
        return null;
    }

    public Optional<TeamDTO> deleteTeam(int id) {
        // TODO
        return null;
    }

    public Optional<PersonDTO> changePerson(PersonDTO newPerson) {
        // TODO
        return null;
    }

    public Optional<TeamDTO> changeTeam(TeamDTO newTeam) {
        // TODO
        return null;
    }

    public Optional<PersonDTO> createPerson(PersonDTO newPerson) {
        // TODO
        return null;
    }

    public Optional<TeamDTO> createTeam(TeamDTO newTeam) {
        // TODO
        return null;
    }
}