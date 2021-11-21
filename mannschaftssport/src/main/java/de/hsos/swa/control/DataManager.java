package de.hsos.swa.control;

import javax.inject.Inject;

import de.hsos.swa.gateway.MockRepository;

public class DataManager implements SearchPerson, CreatePerson, ChangePerson, DeletePerson, SearchTeam, CreateTeam, ChangeTeam, DeleteTeam  {
    
    @Inject MockRepository repository;
}
