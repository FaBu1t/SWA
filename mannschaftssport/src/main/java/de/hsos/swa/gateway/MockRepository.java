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

    public MockRepository() {
        Person hubert = new Person(2, "Hubert");
        Person karl = new Person(3, "Karl");
        ArrayList<Person> a = new ArrayList<>();
        a.add(hubert);
        Team team = new Team(1111, "Team1", a, karl);
        this.createTeam(Team.Converter.toDTO(team));

        Person lisa = new Person(4, "Lisa");
        Person marge = new Person(5, "Marge");
        ArrayList<Person> b = new ArrayList<>();
        b.add(lisa);
        b.add(marge);
        Team team2 = new Team(2222, "Team2", b, marge, "juniors");
        this.createTeam(Team.Converter.toDTO(team2));

        Person grampa = new Person(4, "Grampa");
        Person homer = new Person(5, "Homer");
        ArrayList<Person> c = new ArrayList<>();
        c.add(grampa);
        Team team3 = new Team(3333, "Team3", c, homer, "seniors");
        this.createTeam(Team.Converter.toDTO(team3));
    }

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
            if (entry.getValue().getName().equals(name)) {
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

    public boolean deletePerson(int id) {
        return persons.remove(id) != null;
    }

    public boolean deleteTeam(int id) {
        return teams.remove(id) != null;
    }

    public boolean changePerson(PersonDTO newPerson) {
        if (persons.containsKey(newPerson.id)) {
            persons.put(newPerson.id, Person.Converter.toPerson(newPerson));
            return true;
        }
        return false;
    }

    public Optional<TeamDTO> changeTeam(TeamDTO newTeam) {
        if (teams.containsKey(newTeam.id)) {
            teams.put(newTeam.id, Team.Converter.toTeam(newTeam));
            return Optional.ofNullable(newTeam);
        }
        return Optional.ofNullable(null);
    }

    public boolean createPerson(PersonDTO newPerson) {
        if (persons.putIfAbsent(newPerson.id, Person.Converter.toPerson(newPerson)) == null) {
            return false;
        }
        return true;
    }

    public Optional<TeamDTO> createTeam(TeamDTO newTeam) {
        if (teams.putIfAbsent(newTeam.id, Team.Converter.toTeam(newTeam)) != null) {
            return Optional.ofNullable(null);
        }
        if (newTeam.players != null) {
            for (PersonDTO player : newTeam.players) {
                players.putIfAbsent(player.id, Person.Converter.toPerson(player));
            }
        }
        return Optional.ofNullable(newTeam);
    }

    public Optional<ArrayList<TeamDTO>> getTeamByCategory(String category) {
        System.out.println(category);
        ArrayList<TeamDTO> result = new ArrayList<>();
        for (Map.Entry<Integer, Team> entry : teams.entrySet()) {
            System.out.println(entry.getValue().getCategory());
            if (entry.getValue().getCategory() != null) {
                if (entry.getValue().getCategory().equals(category)) {
                    result.add(Team.Converter.toDTO(entry.getValue()));
                }
            }
        }
        return Optional.ofNullable(result);
    }
}