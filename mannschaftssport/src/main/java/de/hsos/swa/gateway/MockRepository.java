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
    private Map<Integer, Person> players = new HashMap<>();
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
        return Optional.ofNullable(Team.Converter.toDTO(teams.get(id)));
    }

    public Optional<ArrayList<TeamDTO>> getTeam(String name) {
        ArrayList<TeamDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Team> entry : teams.entrySet()) {
            if (entry.getValue().getName() == name) {
                result.add(Team.Converter.toDTO(entry.getValue()));
            }
        }
        return Optional.ofNullable(result);
    }

    public Optional<ArrayList<TeamDTO>> getAllTeam() {
        ArrayList<TeamDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Team> entry : teams.entrySet()) {
            result.add(Team.Converter.toDTO(entry.getValue()));
        }
        return Optional.ofNullable(result);
    }

    public Optional<ArrayList<PersonDTO>> getAllPerson() {
        ArrayList<PersonDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Person> entry : persons.entrySet()) {
            result.add(Person.Converter.toDTO(entry.getValue()));
        }
        return Optional.ofNullable(result);
    }

    public Optional<ArrayList<PersonDTO>> getAllPlayer() {
        ArrayList<PersonDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Person> entry : players.entrySet()) {
            result.add(Person.Converter.toDTO(entry.getValue()));
        }
        return Optional.ofNullable(result);
    }

    public Optional<PersonDTO> deletePerson(int id) {
        return Optional.ofNullable(Person.Converter.toDTO(persons.remove(id)));
    }

    public Optional<TeamDTO> deleteTeam(int id) {
        return Optional.ofNullable(Team.Converter.toDTO(teams.remove(id)));
    }

    public boolean changePerson(PersonDTO newPerson) {
        if (persons.containsKey(newPerson.id)) {
            persons.put(newPerson.id, Person.Converter.toPerson(newPerson));
            return true;
        }
        return false;
    }

    public boolean changeTeam(TeamDTO newTeam) {
        if (teams.containsKey(newTeam.id)) {
            teams.put(newTeam.id, Team.Converter.toTeam(newTeam));
            return true;
        }
        return false;
    }

    public boolean createPerson(PersonDTO newPerson) {
        if (persons.putIfAbsent(newPerson.id, Person.Converter.toPerson(newPerson)) == null) {
            return false;
        }
        return true;
    }

    public boolean createTeam(TeamDTO newTeam) {
        if (teams.putIfAbsent(newTeam.id, Team.Converter.toTeam(newTeam)) == null) {
            return false;
        }
        if (newTeam.players != null) {
            for (PersonDTO player : newTeam.players) {
                players.putIfAbsent(player.id, Person.Converter.toPerson(player));
            }
        }
        return true;
    }
}