package de.hsos.swa.entity;

import java.util.ArrayList;

import de.hsos.swa.entity.DTOs.PersonDTO;
import de.hsos.swa.entity.DTOs.TeamDTO;
import io.smallrye.common.constraint.NotNull;

public class Team {
    @NotNull
    private int id;
    private String name;
    private ArrayList<Person> players;
    private Person manager;
    public String category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Person> getPlayer() {
        return players;
    }

    public Person getManager() {
        return manager;
    }

    public static class Converter {

        public static TeamDTO toDTO(Team team) {
            PersonDTO manager = Person.Converter.toDTO(team.manager);
            ArrayList<PersonDTO> playerDTOs = new ArrayList<>();
            for (Person p : team.getPlayer()) {
                playerDTOs.add(Person.Converter.toDTO(p));
            }

            return new TeamDTO(team.getId(), team.getName(), playerDTOs, manager);
        }

        public static Team toTeam(TeamDTO teamDTO) {
            Person manager = Person.Converter.toPerson(teamDTO.manager);

            ArrayList<Person> players = new ArrayList<Person>();

            for (PersonDTO p : teamDTO.players) {
                players.add(Person.Converter.toPerson(p));
            }

            return new Team(teamDTO.id, teamDTO.name, players, manager);
        }

    }

    public Team(int id, String name, ArrayList<Person> player, Person manager) {
        this.id = id;
        this.name = name;
        this.players = player;
        this.manager = manager;
    }

}
