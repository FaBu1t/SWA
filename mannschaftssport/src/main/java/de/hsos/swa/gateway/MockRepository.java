package de.hsos.swa.gateway;

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
        // TODO
        return null;
    }

    public Optional<PersonDTO> getPerson(String name) {
        // TODO
        return null;
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